package coelho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Falha> falhas = new ArrayList<>();
    public static void Init(){
        menu();
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int op = -1;
        Cliente c;
        do{
            System.out.println("<----------MENU---------->");
            System.out.println("1- Gestão de Clientes");
            System.out.println("2- Gestão de Imóveis");
            System.out.println("3- Gestão de Faturas");
            System.out.println("4- Gestão de Pagamentos");
            System.out.println("5- Gestão de Falhas");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    gestaoClientes();
                    break;
                case 2:
                    gestaoImoveis();
                    break;
                case 3:
                    gestaoFaturas();
                    break;
                case 4:
                    gestaoPagamentos();
                    break;
                case 5:
                    gestaoFalhas();
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoClientes(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------CLIENTES---------->");
            System.out.println("1- Incluir");
            System.out.println("2- Consultar");
            System.out.println("3- Listar");
            System.out.println("4- Excluir");
            System.out.println("5- Alterar");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    addCliente();
                    break;
                case 2:
                    consultCliente();
                    break;
                case 3:
                    listCliente();
                    break;
                case 4:
                    delCliente();
                    break;
                case 5:
                    updateCliente();
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoImoveis(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        Cliente cliente = getCliente();
        if(cliente == null) menu();
        do{
            System.out.println("<----------IMÓVEIS---------->");
            System.out.println("1- Incluir");
            System.out.println("2- Consultar");
            System.out.println("3- Listar");
            System.out.println("4- Excluir");
            System.out.println("5- Alterar");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    cliente.addImovel();
                    break;
                case 2:
                    cliente.consultImovel();
                    break;
                case 3:
                    cliente.listImovel();
                    break;
                case 4:
                    cliente.delImovel();
                    break;
                case 5:
                    cliente.updateImovel();
                    break;
            }

        }while(op != 0);
    }
    
    public static void gestaoFaturas(){
        Cliente cliente = getCliente();
        Imovel imovel = null;
        if(cliente == null) menu();
        else imovel = cliente.getImovel();
        if(imovel == null) menu();
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------FATURAS---------->");
            System.out.println("1- Registro de Consumo");
            System.out.println("2- Listar Faturas Abertas");
            System.out.println("3- Listar Todas as Faturas");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    imovel.addFatura();
                    break;
                case 2:
                    imovel.listFaturaEmAberto();
                    break;
                case 3:
                    imovel.listFatura();
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoPagamentos(){
        Cliente cliente = getCliente();
        Imovel imovel = null;
        if(cliente == null) menu();
        else imovel = cliente.getImovel();
        if(imovel == null) menu();
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------PAGAMENTOS---------->");
            System.out.println("1- Incluir");
            System.out.println("2- Listar Pagamentos Por Fatura");
            System.out.println("3- Listar Todos os Pagamentos");
            System.out.println("4- Listar Reembolsos Por Fatura");
            System.out.println("5- Listar Todos os Reembolsos");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    imovel.addPagamento();
                    break;
                case 2:
                    imovel.listPagamentoFatura();
                    break;
                case 3:
                    imovel.listPagamento();
                    break;
                case 4:
                    imovel.listReembolso();
                    break;
                case 5:
                    imovel.listReembolsoFatura();
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoFalhas(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------FALHAS---------->");
            System.out.println("1- Incluir");
            System.out.println("2- Gestão de Reparos");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    Cliente cliente = cpfFalha();
                    if(cliente != null)
                        cliente.getImovel().addFalha();
                    else
                        addFalha(falhas);
                    break;
                case 2:
                    gestaoReparo();
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoReparo(){
        Cliente cliente = cpfFalha();
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------REPAROS---------->");
            System.out.println("1- Listar Reparos em Aberto");
            System.out.println("2- Encerrar Reparo");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            
            switch (op) {
                case 1:
                    if(cliente != null)
                        cliente.getImovel().listReparo();
                    else
                        listReparo();
                    break;
                case 2:
                    if(cliente != null)
                        cliente.getImovel().encerraReparo();
                    else
                        encerraReparo();
                    break;
            
            }
        }while(op != 0);

    }

    public static Cliente cpfFalha(){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("Deseja informar o CPF do cliente?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    return getCliente();
                case 2:
                    return null;
            }
        }while(op != 1 && op != 2);
        return null;
    }

    public static Cliente getCliente(){
        Scanner sc = new Scanner(System.in);
        String cpf;
        Cliente cl = null;
        try{
            System.out.println("Informe o CPF do cliente que gostaria de acessar para o gerenciamento");
            cpf = sc.nextLine();
            if(!clientes.stream().anyMatch(c -> c.getCPF().equals(cpf))){
                throw new Exception("Este cliente não foi encontrado!");
            }
            else{
                for(Cliente cliente : clientes){
                    if(cliente.getCPF().equals(cpf)){
                        cl = cliente;
                        return cliente;}
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cl;
    }

    public static void addCliente(){
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

    public static void delCliente(){
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
    
    public static void updateCliente(){
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

    public static void listCliente(){
        System.out.println("CLIENTES:");
        for(Cliente cliente : clientes){
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("Nome: " + cliente.getNome());
        }
    }

    public static void consultCliente(){
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

    public static void listReparo(){
        for (Falha falha : falhas){
            if(falha instanceof FalhaDistribuicao){
                ((FalhaDistribuicao)falha).listReparo();
            }
        }
    }
    
    public static void encerraReparo(){
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