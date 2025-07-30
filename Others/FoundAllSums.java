package Others;

import java.util.Scanner;

public class FoundAllSums {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        findAllSums(x);
    }

    public static void findAllSums(int x){
        int y = x-1;
        while(y > 0){
            for(int i = y; i< x; i--){
                if(i+y == x){
                    System.out.println(i + "+" + y);
                } else if(x == i+i+y){
                    System.out.println(i);
                    System.out.println(i+ "+" + i + "+" + y);
                }
            }
            y--;
        }
    }
}
