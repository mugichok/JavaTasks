package Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorts {
    public static void main(String[] args) {
        System.out.println("Введите количество элементов массива: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] arr = new int[x];
        ArrayFilling(arr);
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        simplestSort(arr);
//        shakeSort(arr);
//        shakeSortRightVersion(arr);
//        evenOddSort(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void ArrayFilling(int[] arr){
        Random rand = new Random(56);
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(0, 255);
        }
    }
    //O(n^2)
    public static void bubbleSort(int[] arr){
        int y = 0;
        int len = arr.length;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < len-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    y = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = y;
                }
            }
            len--;
        }
    }
    // O(n^3)
    public static void simplestSort(int[] arr){
        int y = 0;
        for(int i = 0; i < arr.length-1; i++){
            if (arr[i] > arr[i+1]) {
                y = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = y;
                i = -1;
            }
        }
    }

    public static void shakeSort(int[] arr){
        int y = 0;
        int len = arr.length;
        for(int i = 0; i < len-1; i++){
            System.out.println(i);
            if (arr[i] > arr[i+1]) {
                y = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = y;
            }

            if(i == len - 2){
                for(int j = len-1; j >= arr.length-i-1; j--){
                    System.out.println(j);
                    if(arr[j] < arr[j-1]){
                        y = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = y;
                    }
                }
                len--;
                i = arr.length -i;
            }
        }
    }

    public static void shakeSortRightVersion(int[] arr){
        int leftSide = 0;
        int rightSide = arr.length-1;
        int temp = 0;
        while(leftSide < rightSide){
            for(int i = leftSide; i < rightSide; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
            rightSide--;

            for(int i = rightSide; i > leftSide; i--){
                if(arr[i] < arr[i-1]){
                    temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
            leftSide++;
        }
    }

    public static void evenOddSort(int[] arr){
        boolean flag = true;

        while(flag){
            int temp = 0;
            flag = false;
            for(int i = 0; i < arr.length-1; i+=2){
                if(arr[i] > arr[i+1]){
                    temp = arr[i+1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }

            for(int i = 1; i < arr.length-1; i+=2){
                if(arr[i] > arr[i+1]){
                    temp = arr[i+1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pivot = partition(arr, low, high);


            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int temp;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

}
