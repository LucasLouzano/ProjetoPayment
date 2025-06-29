package ProjetoPayment.Payment.adapters.outbound.repositories;

import ProjetoPayment.Payment.adapters.outbound.entity.JpaPaymentValue;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPaymentValueRepository extends JpaRepository<JpaPaymentValue, Long> {
    Optional<JpaPaymentValue> findByPaymentStatus(PaymentStatus status);

}
