package coelho;

import java.util.Date;

public class Pagamento {
    private Date data;
    private float valor;
    private Reembolso reembolso;
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Reembolso getReembolso() {
        return reembolso;
    }
    public Pagamento(float valor){
        this.data = new Date();
        this.valor = valor;
        this.reembolso = null;
    }
}