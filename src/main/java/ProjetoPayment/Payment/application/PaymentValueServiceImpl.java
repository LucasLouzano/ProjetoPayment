package ProjetoPayment.Payment.usercaser;

import ProjetoPayment.Payment.domain.dto.PaymentValueDTO;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.adapters.outbound.repositories.JpaPaymentValueRepository;
import ProjetoPayment.Payment.ports.input.PaymentValueUserCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentValueServiceImpl implements PaymentValueUserCase {
    @Autowired
    private JpaPaymentValueRepository repository;
    @Autowired
    private PaymentValueMapper mapper;

    @Override
    public PaymentValueUserCase findByStatus(PaymentStatus status) {
        return repository.findByPaymentStatus(status).orElse(null);
    }

    @Transactional
    @Override
    public PaymentValueDTO save(PaymentValueUserCase dto) {
        PaymentValueUserCase valuePgm = this.findByStatus(PaymentStatus.CURRENT);
        if (valuePgm != null) {
            valuePgm.setPaymentStatus(PaymentStatus.BEFORE);
            repository.save(valuePgm);
        }
        PaymentValueUserCase newPaymentValue = new PaymentValueUserCase();
        newPaymentValue.setValor(paymentValue.getValor());
        newPaymentValue.setData(LocalDateTime.now());
        newPaymentValue.setPaymentStatus(PaymentStatus.CURRENT);
        repository.save(newPaymentValue);
        return mapper.PagValueToPagValueDTO(newPaymentValue);
    }

    @Override
    public List<PaymentValueUserCase> findAll() {
        return repository.findAll();
    }

}
