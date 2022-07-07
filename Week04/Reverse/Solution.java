import java.util.Scanner;

class Solution {

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            StringBuilder newString = new StringBuilder();
            String input = in.nextLine();
            String[] arr = input.split(" ");

            for (int j = 0; j < arr.length; j++) {
                newString.append(reverse(arr[j]));
                if (j != arr.length - 1) {
                    newString.append(" ");
                }
            }
            System.out.println("Case #" + (i+1) + ": " + newString.toString());
        }
    }
}
