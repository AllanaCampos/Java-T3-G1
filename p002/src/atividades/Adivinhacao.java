package atividades;

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    private int numero;
    public void geraNumero(){
        Random r = new Random();
        this.numero  = r.nextInt(100) + 1;
        System.out.println(numero);
    }
    public int verifica(int chute){
        int dif = this.numero - chute;
        if(dif == 0){
            System.out.println("Parabéns! Você acertou o número");
        }
        else if(dif > 0){
            if(dif > 15){
                if(dif > 30){
                    if(dif > 45)
                        System.out.println("Seu chute foi muito baixo");
                    else
                        System.out.println("Seu chute foi baixo");
                }
                else System.out.println("Seu chute foi um pouco baixo");
            }
            else 
                System.out.println("Quase lá, aumente mais um pouco");
        }
        else if(dif < 0){
            if(dif < 45){
                if(dif < 30){
                    if(dif < 15)
                        System.out.println("Quase lá, diminua mais um pouco");
                    else
                        System.out.println("Seu chute foi um pouco alto");
                }
                else
                    System.out.println("Seu chute foi alto");
            }
            else 
                System.out.println("Seu chute foi muito alto");
        }
        return dif;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0, dif;
        do{
            Adivinhacao a = new Adivinhacao();
            a.geraNumero();
            do{
                System.out.println("Adivinhe o número: ");
                dif = a.verifica(sc.nextInt());
            }while(dif != 0);
            System.out.println("Deseja jogar novamente? (1- Sim / 2- Não)");
            op = sc.nextInt();
        }while(op != 2);
        sc.close();
    }
}