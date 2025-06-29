package ProjetoPayment.Payment.domain.ports.input;

import ProjetoPayment.Payment.domain.dto.PaymentValueDTO;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;

import java.util.List;
public interface PaymentValueUserCase {
    PaymentValueDTO save(PaymentValue paymentValue);
    List<PaymentValue> findAll();
    PaymentValue findByStatus(PaymentStatus status);


}
