import java.util.*;

class Solution {

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0; 
        }
        if (num == 1 || num == 2)
            return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            int input = Integer.parseInt(in.nextLine());
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(fibonacci(input));

        }
    }
}
