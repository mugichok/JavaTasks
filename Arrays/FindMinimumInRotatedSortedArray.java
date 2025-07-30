
package Arrays;// найти минимальное значение отсортированного сдвинутого массива. НА взод подаётся уже сдвинутый массивэ
import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        int x = scanner.nextInt();
        int[] arr = new int[x];
        extracted(scanner, arr);
        System.out.println("Введите число для сдвига массива: ");
        x = scanner.nextInt();
        System.out.println(Arrays.toString(arr));
        // arr = shiftArray(arr, x);
        System.out.println(Arrays.toString(arr));
        // System.out.println(findMin(arr,x));
        int[] arr2 = {3,4,5,1};
        // System.out.println(findMin(arr));
        System.out.println(findMin(arr2));
        System.out.println(findMin2(arr2));

    }

    private static void extracted(Scanner scanner, int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.println("Введите элемент массива: ");
            arr[i] = scanner.nextInt();
        }
    }

    public static int[] shiftArray(int[] arr, int x){
        int[] arr2 = new int[arr.length];
        if(x < arr.length){
            for(int i = 0; i < arr.length-x; i++){
                arr2[i+x] = arr[i];
            }
            for(int i = 0; i < x; i++){
                arr2[i] = arr[arr.length-x+i];
            }
        }
        return arr2;
    }

    public static int findMin(int[] arr, int x){
        return arr[x];
    }

    // человеческое решение

    public static int findMin(int[] arr){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>arr[i+1]){
                return arr[i+1];
            } else if(arr[arr.length-i-1]<arr[arr.length-i-2]){
                return arr[arr.length-i-1];
            }
        }
        return arr[0];
    }

    // альтернитивное решение

    public static int findMin2(int[] arr){
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            if(arr[l] <= arr[r]){
                return arr[l];
            }

            int mid = (l + r)/2;
            if(arr[mid] >= arr[l]){
                l = mid +1;
            } else {
                r = mid;
            }
        }
        return arr[0];
    }
}