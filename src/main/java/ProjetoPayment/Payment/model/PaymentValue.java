package ProjetoPayment.Payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class PaymentValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private LocalDateTime data;
    private String snCurrentValue;

    public PaymentValue() {
    }

    public PaymentValue(Long id, double valor, LocalDateTime data, String snCurrentValue) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.snCurrentValue = snCurrentValue;
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

    public String getSnCurrentValue() {
        return snCurrentValue;
    }

    public void setSnCurrentValue(String snCurrentValue) {
        this.snCurrentValue = snCurrentValue;
    }
}
