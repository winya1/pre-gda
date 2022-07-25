import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            int input = Integer.parseInt(in.nextLine());
            System.out.println("Case #" + (i + 1) + ": ");
            hanoi(input, 1, 3, 2);
        }
    }

    static void hanoi(int m, int source,
                             int target, int spare)
    {
        if (m == 0)
        {
            return;
        }
        hanoi(m - 1, source, spare, target);
        System.out.println(source + " " + target);
        hanoi(m - 1, spare, target, source);

    }

}
