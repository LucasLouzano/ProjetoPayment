package ProjetoPayment.Payment.repository;

import ProjetoPayment.Payment.enuns.PaymentStatus;
import ProjetoPayment.Payment.model.PaymentValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentValueRepository extends JpaRepository<PaymentValue, Long> {
    //    Optional<PaymentValue> findBySnCurrentValue(String snCurrentValue);
    Optional<PaymentValue> findByPaymentStatus(PaymentStatus status);

}
