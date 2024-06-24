package ProjetoPayment.Payment.mapper;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.dto.ValuePaymentDTO;
import ProjetoPayment.Payment.model.PaymentValue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentValueMapper {
    PaymentValueMapper INSTANCE = Mappers.getMapper(PaymentValueMapper.class);

    PaymentValueDTO PagValueToPagValueDTO(PaymentValue paymentValue);
    ValuePaymentDTO mapValorPagToDto(PaymentValueDTO paymentValueDTO);
}
