package ProjetoPayment.Payment.application;

import ProjetoPayment.Payment.domain.dto.PaymentValueDTO;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import ProjetoPayment.Payment.domain.model.PaymentValueRepository;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.domain.userCase.PaymentValueUserCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentValueServiceImpl implements PaymentValueUserCase {
    private final PaymentValueRepository repository;

    private final PaymentValueMapper mapper;

    public PaymentValueServiceImpl(PaymentValueRepository repository, PaymentValueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PaymentValue findByStatus(PaymentStatus status) {
        return repository.findByStatus(status);
    }

    @Transactional
    @Override
    public PaymentValueDTO save(PaymentValue paymentValue) {
        PaymentValue valueCurrent = this.findByStatus(PaymentStatus.CURRENT);
        if (valueCurrent != null) {
            valueCurrent.setPaymentStatus(PaymentStatus.BEFORE);
            repository.save(valueCurrent);
        }
        PaymentValue newPaymentValue = new PaymentValue();
        newPaymentValue.setValor(paymentValue.getValor());
        newPaymentValue.setData(LocalDateTime.now());
        newPaymentValue.setPaymentStatus(PaymentStatus.CURRENT);
        repository.save(newPaymentValue);
        return mapper.toDTO(newPaymentValue);
    }


    @Override
    public List<PaymentValue> findAll() {
        return repository.findAll();
    }

}
