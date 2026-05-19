package Others;

import java.util.Arrays;
import java.util.Map;

public class LargestPositiveIntegerWithNegativeTwin {

    public static void main(String[] args) {
        int[] arr = {-1,-6,-3,-94,-819,-9,-7,-838,-2,-3,-90,-94, -819};
        System.out.println(findMaxN(arr));
    }
    public static int findMaxK(int[] nums) {
        quickSort(nums, 0, nums.length-1);

        for(int i = nums.length-1; i >-1; i--){
            int negative = -nums[i];
            if(binarySearch(nums, negative, 0, nums.length-1) != -1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partititon(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi +1, high);
        }
    }

    public static int partititon(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }

    public static int binarySearch(int[] values, int valueToFind, int l, int r) {
        if (l <= r) {
            return (values[l] == valueToFind) ? l : -1;
        }

        int m = l + (r - l) / 2;

        if (valueToFind > values[m]) {
            return binarySearch(values, valueToFind, m + 1, r);
        } else if (values[m] > valueToFind) {
            return binarySearch(values, valueToFind, l, m - 1);
        }
        return m;
    }


    // Человеческое решение
    public static int findMaxN(int[] arr){
        int ans = -1;

        for(int i: arr){
            for(int j: arr){
                if(i == -j){
                    ans = Math.max(ans, Math.abs(i));
                }
            }
        }
        return ans;
    }
}
