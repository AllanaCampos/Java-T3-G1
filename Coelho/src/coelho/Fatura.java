package coelho;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Fatura {
    private Date data;
    private float ultimaLeitura;
    private float penultimaLeitura;
    private float valor;
    private boolean quitado;
    private ArrayList<Pagamento> pagamentos;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public float getUltimaLeitura() {
        return ultimaLeitura;
    }
    public void setUltimaLeitura(float ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }
    public float getPenultimaLeitura() {
        return penultimaLeitura;
    }
    public void setPenultimaLeitura(float penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public boolean getQuitado(){
        return this.quitado;
    }
    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }
    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    Fatura(float ultimaLeitura, float penultimaLeitura, float valor){
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.valor = valor;
        this.quitado = false;
        this.data = new Date();
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public void addPagamento(){
        float valor;
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor para o pagamento");
        valor = sc.nextFloat();
        Pagamento pagamento = new Pagamento(valor);
        pagamentos.add(pagamento);
        if(this.valor < valor){
            Reembolso reembolso = new Reembolso(valor - this.valor);
            pagamento.setReembolso(reembolso);
            this.quitado = true;
        } 
    }
}