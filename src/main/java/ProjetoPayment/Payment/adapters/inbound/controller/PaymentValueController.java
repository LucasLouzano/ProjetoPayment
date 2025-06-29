package ProjetoPayment.Payment.adapters.inbound.controller;

import ProjetoPayment.Payment.domain.dto.PaymentValueDTO;
import ProjetoPayment.Payment.domain.dto.ValuePaymentDTO;
import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import ProjetoPayment.Payment.mapper.PaymentValueMapper;
import ProjetoPayment.Payment.domain.userCase.PaymentValueUserCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentValueController {

    private final PaymentValueUserCase service;
    private final PaymentValueMapper mapper;

    public PaymentValueController(PaymentValueUserCase service, PaymentValueMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{status}")
    public ResponseEntity<PaymentValueDTO> getByStatus(@PathVariable PaymentStatus status) {
        var value = service.findByStatus(status);
        if (value == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDTO(value));
    }
    @PostMapping
    public ResponseEntity<ValuePaymentDTO> savePaymentValue(@RequestBody @Valid PaymentValue value) {
        var savedDTO = service.save(value);
        if (savedDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(mapper.toValueDTO(savedDTO));
    }

    @GetMapping("/paymentValues")
    public ResponseEntity<List<PaymentValueDTO>> listAll() {
        List<PaymentValueDTO> list = service.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
        if (list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
}

