import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            double executed = npn(in);
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(executed);
        }
    }

    private static double npn(Scanner in) {
        if (in.hasNextDouble())
            return in.nextDouble();

        //if an operator is found
        char operator = in.next().charAt(0);

        if (operator == '+')
            return npn(in) + npn(in);
        if (operator == '-')
            return npn(in) - npn(in);
        if (operator == '*')
            return npn(in) * npn(in);
        if (operator == '/')
            return npn(in) / npn(in);
        if (operator == '^')
            return Math.pow(npn(in), npn(in));

        throw new RuntimeException("operator not allowed for this language");
    }
}
