import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int maximum(int array[]) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int minimum(int array[]) {
        int min = array[1];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            String input = in.nextLine().trim().replaceAll("  +", " ");
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            int max = maximum(numbers);
            int min = minimum(numbers);
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[j] == max || numbers[j] == min) {
                    count = count + 1;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + count);
        }
    }
}
