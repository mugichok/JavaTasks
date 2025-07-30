package Simplest;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Введите число, факториал которого хотите найти: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(findFactorial(x));
        scanner.close();
    }

    public static int findFactorial(int x){
        int result = 1;
        for(int i = x; i>0; i--){
            result *= i;
        }
        return result;
    }
}
