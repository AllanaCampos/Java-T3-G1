package coelho;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Falha> falhas = new ArrayList<>();
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
                    gestaoClientes(clientes);
                    break;
                case 2:
                    gestaoImoveis(getCliente(clientes));
                    break;
                case 3:
                    c = getCliente(clientes);
                    if(c != null) gestaoFaturas(c.getImovel());
                    break;
                case 4:
                    c = getCliente(clientes);
                    if(c != null) gestaoPagamentos(c.getImovel());
                    break;
                case 5:
                    gestaoFalhas(clientes, falhas);
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoClientes(ArrayList<Cliente> clientes){
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
                    App.addCliente(clientes);
                    break;
                case 2:
                    App.consultCliente(clientes);
                    break;
                case 3:
                    App.listCliente(clientes);
                    break;
                case 4:
                    App.delCliente(clientes);
                    break;
                case 5:
                    App.updateCliente(clientes);
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoImoveis(Cliente cliente){
        if(cliente == null)
            main(null);
        Scanner sc = new Scanner(System.in);
        int op = -1;
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
    
    public static void gestaoFaturas(Imovel imovel){
        if(imovel == null)
            main(null);
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

    public static void gestaoPagamentos(Imovel imovel){
        if(imovel == null)
            main(null);
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
                    imovel.listPagamento();
                    break;
                case 3:
                    imovel.listPagamentoFatura();
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

    public static void gestaoFalhas(ArrayList<Cliente> clientes, ArrayList<Falha> falhas){
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
                    Cliente cliente = cpfFalha(clientes);
                    if(cliente != null)
                        cliente.getImovel().addFalha();
                    else
                        App.addFalha(falhas);
                    break;
                case 2:
                    gestaoReparo(clientes, falhas);
                    break;
            }

        }while(op != 0);
    }

    public static void gestaoReparo(ArrayList<Cliente> clientes, ArrayList<Falha> falhas){
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.println("<----------REPAROS---------->");
            System.out.println("1- Listar Reparos em Aberto");
            System.out.println("2- Encerrar Reparo");
            System.out.println("0- Sair");
            op = sc.nextInt();
            sc.nextLine();
            Cliente cliente;
            switch (op) {
                case 1:
                    cliente = cpfFalha(clientes);
                    if(cliente != null)
                        cliente.getImovel().listReparo();
                    else
                        App.listReparo(falhas);
                    break;
                case 2:
                    cliente = cpfFalha(clientes);
                    if(cliente != null)
                        cliente.getImovel().encerraReparo();
                    else
                        App.encerraReparo(falhas);
                    break;
            
            }
        }while(op != 0);

    }

    public static Cliente cpfFalha(ArrayList<Cliente> clientes){
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
                    return getCliente(clientes);
                case 2:
                    return null;
            }
        }while(op != 1 && op != 2);
        return null;
    }

    public static Cliente getCliente(ArrayList<Cliente> clientes){
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
}