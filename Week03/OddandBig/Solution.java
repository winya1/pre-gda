import java.util.Scanner;

public class Solution {

    public static int oddAndBig(int number) {
        if (number > 10 && number % 2 == 1) {
            return number;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int caseInput = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < caseInput; i++) {
            String input = scan.nextLine();
            String[] fragments = input.split(" ");

            if (oddAndBig(Integer.parseInt(fragments[0])) == -1 || oddAndBig(Integer.parseInt(fragments[1])) == -1 || oddAndBig(Integer.parseInt(fragments[2])) == -1) {
                System.out.println("Case #" + (i + 1) + ": No");
            }
            else {
                System.out.println("Case #" + (i + 1) + ": Yes");
            }


        }

    }
}
