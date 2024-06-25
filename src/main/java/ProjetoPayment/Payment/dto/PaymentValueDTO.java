package ProjetoPayment.Payment.dto;


public class PaymentValueDTO {
    double valor;

    public PaymentValueDTO() {
    }

    public PaymentValueDTO(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
