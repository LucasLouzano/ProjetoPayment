package ProjetoPayment.Payment.domain.model;


import java.util.List;

public interface PaymentValueRepository {
    PaymentValue save(PaymentValue paymentValue);
    List<PaymentValue> findAll();
    PaymentValue findByStatus(PaymentStatus status);

}
