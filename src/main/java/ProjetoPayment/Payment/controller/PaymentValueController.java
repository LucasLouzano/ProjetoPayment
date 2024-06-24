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
public class PaymentValueController {
    private PaymentValueService service;
    @Autowired
    private PaymentValueMapper Mapper;

    @GetMapping("/{snValorAtual}")
    public ResponseEntity<PaymentValue> getPaymentValueBy(@PathVariable String snCurrentValue) {
        PaymentValue valorPagamento = service.findBySnCurrentValue(snCurrentValue);
        if (valorPagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valorPagamento);
    }
    @PostMapping
    public ResponseEntity<ValuePaymentDTO> savePaymentValue(@RequestBody @Valid PaymentValue paymentValue) {
        PaymentValueDTO valorPagamentoDTO = service.save(paymentValue);
        ValuePaymentDTO valuePaymentDTO = Mapper.mapValorPagToDto(valorPagamentoDTO);
        if (valuePaymentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(valuePaymentDTO);
    }
    @GetMapping("/paymentValues")
    public ResponseEntity <List<PaymentValue>> getPaymentValue(){
        List<PaymentValue> paymentValuesList = service.findAll();
        if (paymentValuesList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(paymentValuesList);

    }
}

