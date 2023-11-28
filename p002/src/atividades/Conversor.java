package atividades;

import java.util.Scanner;

public class Conversor {
    public static float converte(float valor, float taxaCambio){
        float resultado = 0;
        resultado = taxaCambio * valor;
        return resultado;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        float valor, taxa;
        do{
            System.out.println("Informe a taxa de câmbio: ");
            taxa = sc.nextFloat();
            System.out.println("Informe o valor que deseja converter: ");
            valor = sc.nextFloat();
            System.out.println(valor + " dólares corresponde a " + converte(valor, taxa) + " da moeda desejada.");
            do{
                System.out.println("Deseja fazer outra conversão? (1- Sim / 2- Não)");
                op = sc.nextInt();
            }while(op != 1 && op != 2);
        }while(op != 2);
        sc.close();
    }

}