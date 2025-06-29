package ProjetoPayment.Payment.adapters.outbound.repositories;

import ProjetoPayment.Payment.adapters.outbound.entity.JpaPaymentValue;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import ProjetoPayment.Payment.domain.model.PaymentValueRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepositoryValueImpl implements PaymentValueRepository {

    private final JpaPaymentValueRepository repository;

    public PaymentRepositoryValueImpl(JpaPaymentValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentValue save(PaymentValue paymentValue) {
        JpaPaymentValue jpaPaymentValue = new JpaPaymentValue(paymentValue);
        this.repository.save(jpaPaymentValue);
        return new PaymentValue(
                jpaPaymentValue.getId(),
                jpaPaymentValue.getValor(),
                jpaPaymentValue.getData(),
                jpaPaymentValue.getPaymentStatus());
    }

    @Override
    public List<PaymentValue> findAll() {
        return repository.findAll().stream()
                .map(entity -> new PaymentValue(
                        entity.getId(),
                        entity.getValor(),
                        entity.getData(),
                        entity.getPaymentStatus())).toList();
    }

    @Override
    public PaymentValue findByStatus(PaymentStatus status) {
        return repository.findByPaymentStatus(status).
                map(entity -> new PaymentValue(
                        entity.getId(),
                        entity.getValor(),
                        entity.getData(),
                        entity.getPaymentStatus())).orElse(null);

    }
}
