package coelho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Reparo {
    private String descricao;
    private Date previsao;
    private Date inicio;
    private Date fim;
    private boolean resolvido;
    Reparo reparo;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getFim() {
        return fim;
    }
    public void setFim(Date fim) {
        this.fim = fim;
    }
    public Date getInicio() {
        return inicio;
    }
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public Date getPrevisao() {
        return previsao;
    }
    public void setPrevisao(Date previsao) {
        this.previsao = previsao;
    }
    public boolean getResolvido(){
        return this.resolvido;
    }
    public void setResolvido(boolean resolvido){
        this.resolvido = resolvido;
    }
    public Reparo(String descricao, Date previsao){
        this.descricao = descricao;
        this.previsao = previsao;
        this.inicio = new Date();
        this.resolvido = false;
        this.reparo = null;
    }

    public void newReparo(ArrayList<Reparo> reparos) throws ParseException{
        String descricao;
        Date previsao;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Descreva a atividade a ser desenvolvida para reparar a falha");
            descricao = sc.nextLine();
            System.out.println("Informe a previsão de finalização do reparo utilizando o formato: DD/MM/AAAA");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            previsao = formato.parse(sc.nextLine());
            this.reparo = new Reparo(descricao, previsao);
            reparos.add(this.reparo);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}