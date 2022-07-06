import java.util.Scanner;

public class Solution {  // <- Our testing system requires class name "Solution".
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input % 2 == 0) {
            System.out.println("Even");
        }

        else if (input % 2 == 1 || input % 2 == -1) {
            System.out.println("Odd");
        }
    }

}
