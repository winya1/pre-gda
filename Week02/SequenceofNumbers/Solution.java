import java.util.ArrayList;
import java.util.Scanner;

public class Solution { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] intArray = new int[input];
        int counter = 0;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (counter < intArray.length) {
                    System.out.print(i + " ");
                    counter = counter + 1;
                }
            }

        }
    }

}
