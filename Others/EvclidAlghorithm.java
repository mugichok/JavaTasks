package Others;

public class EvclidAlghorithm {
    public static void main(String[] args) {
        int a = 30;
        int b = 18;

        while(a > 0 && b > 0){
            if(a > b){
                a = a %b;
            } else{
                b = b % a;
            }
        }

        System.out.println(a+b);
    }
}
