package Simplest;

import java.util.Scanner;

public class CheckSimpleNumber {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(checkSimpleNumber(x));
        scanner.close();
    }

    public static boolean checkSimpleNumber(int x){
        if(x == 0 || x == 1){
            return false;
        }
        for(int i = (int) Math.sqrt(x); i>1; i--){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

}
