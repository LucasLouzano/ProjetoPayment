package ProjetoPayment.Payment.config;

import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {
    @Bean
    public PaymentValueMapper paymentValueMapper() {
        return Mappers.getMapper(PaymentValueMapper.class);
    }
}
