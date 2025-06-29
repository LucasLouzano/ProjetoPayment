package ProjetoPayment.Payment.mapper;

import ProjetoPayment.Payment.domain.dto.PaymentValueDTO;
import ProjetoPayment.Payment.domain.dto.ValuePaymentDTO;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentValueMapper {
    PaymentValueMapper INSTANCE = Mappers.getMapper(PaymentValueMapper.class);

    PaymentValueDTO toDTO(PaymentValue paymentValue);

    ValuePaymentDTO toValueDTO(PaymentValueDTO dto);
}

