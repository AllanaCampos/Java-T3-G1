package coelho;

import java.util.Date;

public class Falha {
    private String descricao;
    private Date previsao;
    private Date inicio;
    private Date fim;

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
    public Falha(String descricao, Date previsao){
        this.descricao = descricao;
        this.previsao = previsao;
        this.inicio = new Date();
    }
}