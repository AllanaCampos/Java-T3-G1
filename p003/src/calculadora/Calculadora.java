package calculadora;

import java.util.Scanner;

public class Calculadora {
	
	public static void sum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os valores para a soma: ");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float tot = num1 + num2;
		System.out.println("O resultado da soma de " + num1 + " com " + num2 + " é: " + tot);
	}
	
	public static void sub() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os valores para a subtração: ");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float tot =  num1 - num2;
		System.out.println("O resultado da subtracao de " + num1 + " por " + num2 + " é: " + tot);
    }
	
	public static void mul() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os valores para a multiplicação: ");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
		float tot = num1 * num2;
        sc.close();
        System.out.println("O resultado da multiplicacao de " + num1 + " com " + num2 + " é: " + tot);
    }
	
	public static void divFloat () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os valores para a divisão: ");
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
		float tot = num1 / num2;
        System.out.println("O resultado da divisao de " + num1 + " por " + num2 + " é: " + tot);
	}

    public static void divInteiro (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os valores para a divisão: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if(num2 == 0){
            throw new DivideByZeroException("Divisão por zero!");
        }
        else{ 
        	int tot = num1 / num2;
        	System.out.println("O resultado da divisao de " + num1 + " por " + num2 + " é: " + tot);
        }
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
        do{
            System.out.println("<----------MENU---------->");
            System.out.println("1- Soma");
            System.out.println("2- Subtracao");
            System.out.println("3- Multiplicacao");
            System.out.println("4- Divisao com ponto flutuante");
            System.out.println("5- Divisao de inteiros");
            System.out.println("0- Sair");
            op = sc.nextInt();
            switch(op) {
            case 1:
                Calculadora.sum();
                break;
            case 2:
                Calculadora.sub();
                break;
            case 3:
                Calculadora.mul();
                break;
            case 4:
                Calculadora.divFloat();
                break;
            case 5:
                try{Calculadora.divInteiro();}
                catch(DivideByZeroException e){ System.out.println("Divisões por zero não são possíveis com números inteiros, tente novamente");}
                break;
            }
        }while(op!=0);
		sc.close();		
	}
	
}