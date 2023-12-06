package coelho;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String CPF;
    private String nome;
    private ArrayList<Imovel> imoveis;

    public String getCPF(){
        return this.CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public Cliente(String CPF, String nome){
        this.CPF = CPF;
        this.nome = nome;
        this.imoveis = new ArrayList<>();
    }
    
    public void addImovel(){
        Scanner sc = new Scanner(System.in);
        String endereco;
        float ultimaLeitura;
        System.out.println("Informe o endereço do imóvel");
        endereco = sc.nextLine();
        System.out.println("Informe o valor atual do contador do relógio do imóvel");
        ultimaLeitura = sc.nextFloat();
        sc.nextLine();
        Imovel imovel = new Imovel(endereco, ultimaLeitura);
        this.imoveis.add(imovel);
        System.out.println("Imóvel adicionado com sucesso! Matrícula: " + imovel.getMatricula());
    }

    public void delImovel(){
        Scanner sc = new Scanner(System.in);
        int matricula;
        try{
            System.out.println("Informe a matrícula do imóvel");
            matricula = sc.nextInt();
            sc.nextLine();
            if(!this.imoveis.stream().anyMatch(i -> i.getMatricula() == matricula)){
                throw new Exception("Este imóvel não foi encontrado!");
            }
            else{
                for(Imovel imovel : this.imoveis){
                    if(imovel.getMatricula() == matricula){
                        this.imoveis.remove(imovel);
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void updateImovel(){
        Scanner sc = new Scanner(System.in);
        int matricula;
        String endereco;
        try{
            System.out.println("Informe a matrícula do imóvel");
            matricula = sc.nextInt();
            sc.nextLine();
            if(!this.imoveis.stream().anyMatch(i -> i.getMatricula() == matricula)){
                throw new Exception("Este imóvel não foi encontrado!");
            }
            else{
                System.out.println("Informe o novo endereço do imóvel");
                endereco = sc.nextLine();
                for(Imovel imovel : this.imoveis){
                    if(imovel.getMatricula() == matricula){
                        imovel.setEndereco(endereco);
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void listImovel(){
        System.out.println("IMÓVEIS:");
        for(Imovel imovel : this.imoveis){
            System.out.println("Matrícula: " + imovel.getMatricula());
            System.out.println("Endereço: " + imovel.getEndereco());
            System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
            System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
        }
    }

    public void consultImovel(){
        Scanner sc = new Scanner(System.in);
        int matricula;
        try{
            System.out.println("Informe a matrícula do imóvel");
            matricula = sc.nextInt();
            sc.nextLine();
            if(!this.imoveis.stream().anyMatch(i -> i.getMatricula() == matricula)){
                throw new Exception("Este imóvel não foi encontrado!");
            }
            else{
                for(Imovel imovel : this.imoveis){
                    if(imovel.getMatricula() == matricula){
                        System.out.println("Matrícula: " + imovel.getMatricula());
                        System.out.println("Endereço: " + imovel.getEndereco());
                        System.out.println("Última Leitura: " + imovel.getUltimaLeitura());
                        System.out.println("Penúltima Leitura: " + imovel.getPenultimaLeitura());
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Imovel getImovel(){
        Scanner sc = new Scanner(System.in);
        int matricula;
        try{
            System.out.println("Informe a matrícula do imóvel correspondente para o gerenciamento");
            matricula = sc.nextInt();
            sc.nextLine();
            if(!this.imoveis.stream().anyMatch(i -> i.getMatricula() == matricula)){
                throw new Exception("Este imóvel não foi encontrado!");
            }
            else{
                for(Imovel imovel : this.imoveis){
                    if(imovel.getMatricula() == matricula){
                        return imovel;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}