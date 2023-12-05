package coelho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void addCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        String cpf, nome;
        try{
            System.out.println("Informe o CPF do cliente");
            cpf = sc.nextLine();
            if(clientes.stream().anyMatch(c -> c.getCPF().equals(cpf))){
                throw new Exception("Este cliente já está cadastrado!");
            }
            else{
                System.out.println("Informe o nome do cliente");
                nome = sc.nextLine();
                Cliente cliente = new Cliente(cpf, nome);
                clientes.add(cliente);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public static void delCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        String cpf;
        try{
            System.out.println("Informe o CPF do cliente");
            cpf = sc.nextLine();
            if(!clientes.stream().anyMatch(c -> c.getCPF().equals(cpf))){
                throw new Exception("Este cliente não foi encontrado!");
            }
            else{
                for(Cliente cliente : clientes){
                    if(cliente.getCPF().equals(cpf)){
                        clientes.remove(cliente);
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static void updateCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        String cpf, nome;
        try{
            System.out.println("Informe o CPF do cliente");
            cpf = sc.nextLine();
            if(!clientes.stream().anyMatch(c -> c.getCPF().equals(cpf))){
                throw new Exception("Este cliente não foi encontrado!");
            }
            else{
                System.out.println("Informe o novo nome do cliente");
                nome = sc.nextLine();
                for(Cliente cliente : clientes){
                    if(cliente.getCPF().equals(cpf)){
                        cliente.setNome(nome);
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void listCliente(ArrayList<Cliente> clientes){
        System.out.println("CLIENTES:");
        for(Cliente cliente : clientes){
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("Nome: " + cliente.getNome());
        }
    }

    public static void consultCliente(ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        String cpf;
        try{
            System.out.println("Informe o CPF do cliente");
            cpf = sc.nextLine();
            if(!clientes.stream().anyMatch(c -> c.getCPF().equals(cpf))){
                throw new Exception("Este cliente não foi encontrado!");
            }
            else{
                for(Cliente cliente : clientes){
                    if(cliente.getCPF().equals(cpf)){
                        System.out.println("CPF: " + cliente.getCPF());
                        System.out.println("Nome: " + cliente.getNome());
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void addFalha(ArrayList<Falha> falhas){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("Qual o tipo de falha?");
            System.out.println("1- Geração");
            System.out.println("2- Distribuição");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    try {
                        addFalhaGeracao(falhas);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        addFalhaDistribuicao(falhas);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }while(op != 1 && op != 2);
    }

    public static void listReparo(ArrayList<Falha> falhas){
        for (Falha falha : falhas){
            if(falha instanceof FalhaDistribuicao){
                ((FalhaDistribuicao)falha).listReparo();
            }
        }
    }
    
    public static void encerraReparo(ArrayList<Falha> falhas){
        for (Falha falha : falhas){
            if(falha instanceof FalhaDistribuicao){
                ((FalhaDistribuicao)falha).encerrarReparo();
            }
        }
    }

    public static void addFalhaDistribuicao(ArrayList<Falha> falhas) throws ParseException{
        Scanner sc = new Scanner(System.in);
        String descricao;
        Date previsao;
        try{
            System.out.println("Descreva a falha");
            descricao = sc.nextLine();
            System.out.println("Informe a previsão para resolução da falha utilizando o formato: DD/MM/AAAA");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            previsao = formato.parse(sc.nextLine());
            FalhaDistribuicao falha = new FalhaDistribuicao(descricao, previsao);
            falhas.add(falha);
            falha.addReparo();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }  

    public static void addFalhaGeracao(ArrayList<Falha> falhas) throws ParseException{
        Scanner sc = new Scanner(System.in);
        String descricao;
        Date previsao;
        try{
            System.out.println("Descreva a falha");
            descricao = sc.nextLine();
            System.out.println("Informe a previsão para resolução da falha utilizando o formato: DD/MM/AAAA");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            previsao = formato.parse(sc.nextLine());
            FalhaGeracao falha = new FalhaGeracao(descricao, previsao);
            falhas.add(falha);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}