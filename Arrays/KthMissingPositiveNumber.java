/*
Дан отсортированный массив arr натуральных чисел и целое число k.
Верните k-ое пропущенное число в этом массиве
 */

package Arrays;

import java.util.*;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {

        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(missingPositiveNumber(arr,k));
        System.out.println(missingPositiveNumber1(arr,k));
    }

    static int missingPositiveNumber(int[] arr, int k){
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<Integer> arrMiss = new ArrayList<>();

        int j = 1;

        for(int i = 0; i < k; i++){
            if(list.contains(j)){
                i--;
                j++;
                continue;
            }
            arrMiss.add(j);
            j++;
        }
        return arrMiss.get(k-1);
    }

    // человеческое решение
    static int missingPositiveNumber1(int[] arr, int k) {
        int l = 0, r = arr.length-1;

        while (l <=r){
            int mid = l + (r-l)/2;

            if(arr[mid] - (mid +1) < k){
                l = mid +1;
            } else {
                r = mid-1;
            }
        }
        return l+k;
    }
}
