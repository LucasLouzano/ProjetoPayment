package ProjetoPayment.Payment.service;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.model.PaymentValue;

import java.util.List;
public interface PaymentValueService {
    PaymentValue findBySnCurrentValue(String snCurrentValue);
    PaymentValueDTO save(PaymentValue dto);
    List<PaymentValue> findAll();
    PaymentValue deleteAll(Long id);

}
