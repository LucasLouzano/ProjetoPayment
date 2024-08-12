package ProjetoPayment.Payment.controller;

import ProjetoPayment.Payment.dto.PaymentValueDTO;
import ProjetoPayment.Payment.dto.ValuePaymentDTO;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.model.PaymentValue;
import ProjetoPayment.Payment.service.PaymentValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PaymentValueController {
    @Autowired
    private PaymentValueService service;
    @Autowired
    private PaymentValueMapper Mapper;

    @GetMapping("/{snCurrentValue}")
    public ResponseEntity<PaymentValue> getPaymentValueBy(@PathVariable String snCurrentValue) {
        PaymentValue valorPagamento = service.findBySnCurrentValue(snCurrentValue);
        if (valorPagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valorPagamento);
    }
    @PostMapping
    public ResponseEntity<?> savePaymentValue(@RequestBody @Valid PaymentValue dto) {
        try {
            PaymentValueDTO PaymentDTO = service.save(dto);
            ValuePaymentDTO valuePaymentDTO = Mapper.mapValorPagToDto(PaymentDTO);
                return ResponseEntity.ok().body(valuePaymentDTO);
            }catch(IllegalStateException e){
                return ResponseEntity.status(403).body(e.getMessage());
        }
    }
    @GetMapping("/paymentValues")
    public ResponseEntity <List<PaymentValue>> getPaymentValue(){
        List<PaymentValue> paymentValuesList = service.findAll();
        if (paymentValuesList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(paymentValuesList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentValue> deletePaymentValue(@PathVariable Long id){
        PaymentValue paymentValue = service.deleteAll(id);
        if (paymentValue == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentValue);

    }
}

