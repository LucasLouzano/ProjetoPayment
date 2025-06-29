package ProjetoPayment.Payment.adapters.outbound.entity;

import ProjetoPayment.Payment.domain.model.PaymentStatus;
import ProjetoPayment.Payment.domain.model.PaymentValue;
import jakarta.persistence.*;


import java.time.LocalDateTime;
@Entity
public class JpaPaymentValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public JpaPaymentValue() {
    }

    public JpaPaymentValue(PaymentValue model) {
        this.id = model.getId();
        this.valor = model.getValor();
        this.data = model.getData();
        this.paymentStatus = model.getPaymentStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
