package ProjetoPayment.Payment.service.impl;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.enuns.PaymentStatus;
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
    public PaymentValue findByStatus(PaymentStatus status) {
        return repository.findByPaymentStatus(status).orElse(null);
    }

    @Transactional
    @Override
    public PaymentValueDTO save(PaymentValue paymentValue) {
        PaymentValue valuePgm = this.findByStatus(PaymentStatus.CURRENT);
        if (valuePgm != null) {
            valuePgm.setPaymentStatus(PaymentStatus.BEFORE);
            repository.save(valuePgm);
        }
        PaymentValue newPaymentValue = new PaymentValue();
        newPaymentValue.setValor(paymentValue.getValor());
        newPaymentValue.setData(LocalDateTime.now());
        newPaymentValue.setPaymentStatus(PaymentStatus.CURRENT);
        repository.save(newPaymentValue);
        return mapper.PagValueToPagValueDTO(newPaymentValue);
    }

    @Override
    public List<PaymentValue> findAll() {
        return repository.findAll();
    }

}
