package ProjetoPayment.Payment.model;

import ProjetoPayment.Payment.enuns.PaymentStatus;


import java.util.List;

public interface PaymentValueRepository {
    PaymentValue save(PaymentValue paymentValue);
    List<PaymentValue> findAll();
    PaymentValue findByStatus(PaymentStatus status);

}
