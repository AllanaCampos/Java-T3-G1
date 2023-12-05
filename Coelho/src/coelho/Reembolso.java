package coelho;

import java.util.Date;

public class Reembolso {
    private Date data;
    private float valor;
    public Date getData() {
        return data;
    }
    public float getValor() {
        return valor;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Reembolso(float valor){
        this.data = new Date();
        this.valor = valor;
    }
}