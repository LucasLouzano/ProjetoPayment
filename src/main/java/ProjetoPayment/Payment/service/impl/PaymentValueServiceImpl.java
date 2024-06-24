package ProjetoPayment.Payment.service.impl;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.model.PaymentValue;
import ProjetoPayment.Payment.repository.PaymentValueRepository;
import ProjetoPayment.Payment.service.PaymentValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentValueServiceImpl implements PaymentValueService {
    @Autowired
    private PaymentValueRepository repository;
    private PaymentValueMapper mapper;
    @Override
    public PaymentValue findBySnCurrentValue(String snCurrentValue) {
        return repository.findBySnCurrentValue(snCurrentValue).orElse(null);
    }

    @Override
    public PaymentValueDTO save(PaymentValue paymentValue) {
        PaymentValue valuePgm = this.findBySnCurrentValue("S");
        if (valuePgm != null) {
            valuePgm.setSnValorAtual("N");
            repository.save(valuePgm);

        }
        PaymentValue newPaymentValue = new PaymentValue();
        newPaymentValue.setValor(paymentValue.getValor());
        newPaymentValue.setData(LocalDateTime.now());
        newPaymentValue.setSnValorAtual("S");
        repository.save(newPaymentValue);
        return mapper.PagValueToPagValueDTO(newPaymentValue);
    }

    @Override
    public List<PaymentValue> findAll() {
        return repository.findAll();
    }
}
