package ProjetoPayment.Payment.domain.model;

import java.time.LocalDateTime;

public class PaymentValue {

    private Long id;
    private double valor;
    private LocalDateTime data;
    private PaymentStatus paymentStatus;

    public PaymentValue() {

    }

    public PaymentValue(Long id, double valor, LocalDateTime data, PaymentStatus paymentStatus) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.paymentStatus = paymentStatus;
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
