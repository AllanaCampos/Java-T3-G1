package coelho;

import java.util.ArrayList;
import java.util.Scanner;

public class Imovel {
    private int matricula;
    private String endereco;
    private float ultimaLeitura;
    private float penultimaLeitura;
    private ArrayList<Fatura> faturas;
    private ArrayList<Falha> falhas;
    public static int index;
    public int getMatricula(){
        return this.matricula;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public float getUltimaLeitura(){
        return this.ultimaLeitura;
    }
    public void setUltimaLeitura(float ultimaLeitura){
        this.ultimaLeitura = ultimaLeitura;
    }
    public float getPenultimaLeitura(){
        return this.penultimaLeitura;
    }
    public void setPenultimaLeitura(float penultimaLeitura){
        this.penultimaLeitura = penultimaLeitura;
    }

    public Imovel(String endereco, float ultimaLeitura){
        this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = ultimaLeitura;
        this.faturas = new ArrayList<Fatura>();
        this.falhas = new ArrayList<Falha>();
        this.matricula = index;
        index++;
    }
    public void lerConsumo(){
        Scanner sc = new Scanner(System.in);
        float ultimaLeitura;
        System.out.println("Informe o valor atual do contador do relógio do imóvel");
        ultimaLeitura = sc.nextFloat();
        this.penultimaLeitura = this.ultimaLeitura;
        this.ultimaLeitura = ultimaLeitura;
    }
    public void addFatura(){
        float valor;
        lerConsumo();
        System.out.println("Última Leitura: " + this.ultimaLeitura);
        System.out.println("Penúltima Leitura: " + this.penultimaLeitura);
        valor = (this.ultimaLeitura - this.penultimaLeitura) * 10;
        Fatura fatura = new Fatura(this.ultimaLeitura, this.penultimaLeitura, valor);
        this.faturas.add(fatura);        
    }

    public void listFatura(){
        for(Fatura fatura : this.faturas){
            System.out.println("Data: " + fatura.getData());
            System.out.println("Última Leitura: " + fatura.getUltimaLeitura());
            System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura());
            System.out.println("Valor: " + fatura.getValor());
            if(fatura.getQuitado()) System.out.println("Paga");
            else System.out.println("Em aberto");
        }
    }

    public void listFaturaEmAberto(){
        for(Fatura fatura : this.faturas){
            if(!fatura.getQuitado()){
                System.out.println("Data: " + fatura.getData());
                System.out.println("Última Leitura: " + fatura.getUltimaLeitura());
                System.out.println("Penúltima Leitura: " + fatura.getPenultimaLeitura());
                System.out.println("Valor: " + fatura.getValor());
            }
        }
    }

    public void addPagamento(){
        Scanner sc = new Scanner(System.in);
        int i = 0, indice;
        try{
            System.out.println("Informe qual fatura gostaria de pagar");
            for(Fatura fatura : this.faturas){
                if(!fatura.getQuitado()){
                    i++;
                    System.out.println("Fatura: " + i);
                    System.out.println("Data: " + fatura.getData());
                    System.out.println("Valor: " + fatura.getValor());
                }
            }
            indice = sc.nextInt();
            sc.nextLine();
            if(indice < 1 && indice > i){
                throw new Exception("Esta fatura não foi encontrado!");
            }
            else{
                i = 1;
                for(Fatura fatura : this.faturas){
                    if(!fatura.getQuitado()){
                        if(indice == i)
                            fatura.addPagamento();
                        i++;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void listPagamento(){
        for(Fatura fatura : this.faturas){
            System.out.println("Fatura:");
            System.out.println("Data: " + fatura.getData() + "\tValor: " + fatura.getValor());
            System.out.println("Pagamentos:");
            for(Pagamento pagamento : fatura.getPagamentos()){
                System.out.println("Data: " + pagamento.getData() + "\tValor: " + pagamento.getValor());
            }
        }
    }
    public void listPagamentoFatura(){
        Scanner sc = new Scanner(System.in);
        int i = 0, indice;
        try{
            System.out.println("Informe qual fatura gostaria de vizualizar os pagamentos");
            for(Fatura fatura : this.faturas){
                i++;
                System.out.println("Fatura: " + i);
                System.out.println("Data: " + fatura.getData());
                System.out.println("Valor: " + fatura.getValor());
            }
            indice = sc.nextInt();
            sc.nextLine();
            if(indice < 1 && indice > i){
                throw new Exception("Esta fatura não foi encontrado!");
            }
            else{
                i = 1;
                for(Fatura fatura : this.faturas){
                    if(indice == i){
                        for(Pagamento pagamento : fatura.getPagamentos()){
                            System.out.println("Data: " + pagamento.getData() + "\tValor: " + pagamento.getValor());
                        }
                    }
                    i++;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void listReembolso(){
        for(Fatura fatura : this.faturas){
            System.out.println("Fatura:");
            System.out.println("Data: " + fatura.getData() + "\tValor: " + fatura.getValor());
            System.out.println("Pagamentos:");
            for(Pagamento pagamento : fatura.getPagamentos()){
                if(!pagamento.getReembolso().equals(null)){
                    System.out.println("Data: " + pagamento.getData() + "\tValor: " + pagamento.getValor());
                    System.out.println("Reembolso:");
                    System.out.println("Data: " + pagamento.getReembolso().getData() + "\tValor: " + pagamento.getReembolso().getValor());
                }
            }
        }
    }

    public void listReembolsoFatura(){
        Scanner sc = new Scanner(System.in);
        int i = 0, indice;
        try{
            System.out.println("Informe qual fatura gostaria de vizualizar os reembolsos");
            for(Fatura fatura : this.faturas){
                i++;
                System.out.println("Fatura: " + i);
                System.out.println("Data: " + fatura.getData());
                System.out.println("Valor: " + fatura.getValor());
            }
            indice = sc.nextInt();
            sc.nextLine();
            if(indice < 1 && indice > i){
                throw new Exception("Esta fatura não foi encontrado!");
            }
            else{
                i = 1;
                for(Fatura fatura : this.faturas){
                    if(indice == i){
                        System.out.println("Pagamentos:");
                        for(Pagamento pagamento : fatura.getPagamentos()){
                           if(!pagamento.getReembolso().equals(null)){
                                System.out.println("Data: " + pagamento.getData() + "\tValor: " + pagamento.getValor());
                                System.out.println("Reembolso:");
                                System.out.println("Data: " + pagamento.getReembolso().getData() + "\tValor: " + pagamento.getReembolso().getValor());
                            }
                        }
                    }
                    i++;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addFalha(){
        App.addFalha(falhas);
    }
    
    public void listReparo(){
        for (Falha falha : this.falhas){
            if(falha instanceof FalhaDistribuicao){
                ((FalhaDistribuicao)falha).listReparo();
            }
        }
    }

    public void encerraReparo(){
        for (Falha falha : this.falhas){
            if(falha instanceof FalhaDistribuicao){
                ((FalhaDistribuicao)falha).encerrarReparo();
            }
        }
    }
}