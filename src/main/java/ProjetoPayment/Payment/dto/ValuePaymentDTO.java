package ProjetoPayment.Payment.dto;


public class ValuePaymentDTO {
    double valor;

    public ValuePaymentDTO() {
    }

    public ValuePaymentDTO(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
