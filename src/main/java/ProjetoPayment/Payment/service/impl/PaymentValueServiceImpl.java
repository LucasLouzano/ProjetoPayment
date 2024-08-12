package ProjetoPayment.Payment.service.impl;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.model.PaymentValue;
import ProjetoPayment.Payment.repository.PaymentValueRepository;
import ProjetoPayment.Payment.service.PaymentValueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentValueServiceImpl implements PaymentValueService {
    @Autowired
    private PaymentValueRepository repository;
    @Autowired
    private PaymentValueMapper mapper;

    @Override
    public PaymentValue findBySnCurrentValue(String snCurrentValue) {
        return repository.findBySnCurrentValue(snCurrentValue).orElse(null);
    }

    @Transactional
    @Override
    public PaymentValueDTO save(PaymentValue paymentValue) {
        PaymentValue valuePgm = this.findBySnCurrentValue("S");
        if (valuePgm != null && isPaymentOverdue(valuePgm.getData())) {
            throw new IllegalStateException("O pagamento está em atraso. Não é possível salvar um novo valor de pagamento.");
        }
        if (valuePgm != null) {
            valuePgm.setSnCurrentValue("N");
            repository.save(valuePgm);
        }
        PaymentValue newPaymentValue = new PaymentValue();
        newPaymentValue.setValor(paymentValue.getValor());
        newPaymentValue.setData(LocalDateTime.now());
        newPaymentValue.setSnCurrentValue("S");
        repository.save(newPaymentValue);
        return mapper.PagValueToPagValueDTO(newPaymentValue);
    }
    public boolean isPaymentOverdue(LocalDateTime paymentDate) {
        LocalDateTime paymentDueDate = paymentDate.plusMonths(1);
        return LocalDateTime.now().isAfter(paymentDueDate);
    }
//plusMinutes(1)
    @Override
    public List<PaymentValue> findAll() {
        return repository.findAll();
    }
    @Override
    public PaymentValue deleteAll(Long id) {
       repository.deleteAll();
        return null;
    }
}
