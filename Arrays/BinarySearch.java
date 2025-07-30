import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
        System.out.println(binarySearch(list, 7));
    }

    public static int binarySearch(List<Integer> list, int x){
        if(list.get(list.size()/2) == x){
            return list.get(list.size()/2);
        }
        if(list.get(list.size()/2) > x){
            return binarySearch(list.subList(0,list.size()/2), x);
        } else {
            return binarySearch(list.subList(list.size()/2, list.size()), x);
        }
    }
}
