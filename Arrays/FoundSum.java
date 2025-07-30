import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoundSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,6,2,4,1,8));
        int sum = 0;
        // sum = findSum(list, sum);
        // System.out.println(sum);
        int[] arr = {1,2,3,4,5,3,2,4,24};
        sum = findSum1(arr, sum);
        System.out.println(sum);
    }


    // список
    public static int findSum(List<Integer> list, int sum){
        if(list.size() <= 1){
            return sum + list.get(0);
        } else{
            sum += list.remove(0);
            return findSum(list, sum);
        }

    }

    // массив
    public static int findSum1(int[] arr, int sum){
        if(arr.length <= 1){
            return sum + arr[0];
        } else {
            sum += arr[arr.length-1];
            return findSum1(Arrays.copyOf(arr, arr.length-1), sum);
        }
    }
}
