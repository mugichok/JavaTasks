package Arrays.NgtuHomework;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[1000];

        System.out.println(Arrays.toString(fillingArray(arr)));
        System.out.println(Arrays.toString(bubblesort(arr)));

        System.out.println();

        System.out.println(Arrays.toString(fillingArray(arr)));
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] fillingArray(int[] arr) {
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 101);
        }
        return arr;
    }

    public static int[] bubblesort(int[] arr) {
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void quicksort(int[] arr, int first, int last) {
        if (first < last) {
            int pi = partition(arr, first, last);

            quicksort(arr, first, pi - 1);
            quicksort(arr, pi + 1, last);
        }
    }

    public static int partition(int[] arr, int first, int last) {
        int pivot = arr[last];
        int i = first - 1;
        int temp;

        for (int j = first; j < last; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

            temp = arr[i + 1];
            arr[i + 1] = arr[last];
            arr[last] = temp;

            return i + 1;
    }
}

