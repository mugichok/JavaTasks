package Arrays.NgtuHomework;

import java.util.Arrays;

public class PythagoreanTriangle {

    public static void main(String[] args) {
        int[][] pythagoreanTriangle = createTriangle(20);
    }

    public static int[][] createTriangle(int countRows){
        int[][] pythagoreanTriangle = new int[countRows][];

        for(int i = 0; i < countRows; i++) {

            pythagoreanTriangle[i] = new int[i+1];
            pythagoreanTriangle[i][0] = 1;
            pythagoreanTriangle[i][i] = 1;

            for(int j = 1; j < i; j++){
                    pythagoreanTriangle[i][j] = pythagoreanTriangle[i - 1][j] + pythagoreanTriangle[i - 1][j - 1];
                }
            System.out.println(Arrays.toString(pythagoreanTriangle[i]));
        }
        return pythagoreanTriangle;
    }
}
