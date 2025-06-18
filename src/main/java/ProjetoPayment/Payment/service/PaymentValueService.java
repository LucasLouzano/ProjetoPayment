package ProjetoPayment.Payment.service;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.enuns.PaymentStatus;
import ProjetoPayment.Payment.model.PaymentValue;

import java.util.List;
public interface PaymentValueService {
    PaymentValueDTO save(PaymentValue dto);
    List<PaymentValue> findAll();
    PaymentValue findByStatus(PaymentStatus status);


}
