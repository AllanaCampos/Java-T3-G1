package atividades;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {
    private ArrayList<Integer> array;

    public ManipulaArray(){
        array = new ArrayList<>();
    }

    public void geraArray(){
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            array.add(r.nextInt(500));
        }
    }

    public void pedirArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe quantos valores terão no array: ");
        int tot = sc.nextInt();
        for(int i = 0; i < tot; i++){
            System.out.println("Informe um número para ser armazenado no array: ");
            array.add(sc.nextInt());
        }
        sc.close();
    }

    public int soma(){
        int tot = 0;
        for(int i = 0; i < array.size(); i++){
            tot += array.get(i);
        }
        return tot;
    }

    public int maiorValor(){
        int val = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(val < array.get(i))
                val = array.get(i);
        }
        return val;
    }

    public int menorValor(){
        int val = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(val > array.get(i))
                val = array.get(i);
        }
        return val;
    }

    public void limparArray(){
        array.clear();
    }

    public static void main(String[] args) {
        ManipulaArray m = new ManipulaArray();
        m.geraArray();
        System.out.println("Maior Valor: " + m.maiorValor());
        System.out.println("Menor Valor: " + m.menorValor());
        System.out.println("Soma: " + m.soma());
        m.limparArray();
        m.pedirArray();
        System.out.println("Maior Valor: " + m.maiorValor());
        System.out.println("Menor Valor: " + m.menorValor());
        System.out.println("Soma: " + m.soma());
    }
}