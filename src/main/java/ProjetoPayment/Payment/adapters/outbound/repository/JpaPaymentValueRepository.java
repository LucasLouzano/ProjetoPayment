package ProjetoPayment.Payment.adapters.outbound.repository;

import ProjetoPayment.Payment.adapters.outbound.entity.JpaPaymentValue;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface JpaPaymentValueRepository extends JpaRepository<JpaPaymentValue, Long> {
    Optional<JpaPaymentValue> findByPaymentStatus(PaymentStatus status);

}