import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int[] rotateArrayRight(int[] arr, int noOfRotations) {
        
        // first few set of conditions for edge cases 
        if (noOfRotations == 0) {
            return arr;
        }
        else if (noOfRotations > arr.length && arr.length % noOfRotations == 0 && noOfRotations != 1) {
            return arr;
        }
        else if (noOfRotations == arr.length) {
            return arr;
        } else {
            if (noOfRotations > arr.length) {
                noOfRotations = noOfRotations % arr.length;
            }
            
            //Using arraycopy to split the array and copy over the right rotation to avoid runtime error
            int[] rightRotation = new int[noOfRotations];
            int[] array = new int[arr.length - noOfRotations];
            System.arraycopy(arr, 0, array, 0, array.length);
            System.arraycopy(arr, array.length, rightRotation, 0, noOfRotations);
            int [] result = new int[arr.length];
            System.arraycopy(rightRotation, 0, result, 0, noOfRotations);
            System.arraycopy(array,0, result, rightRotation.length, array.length);
            return result;
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            String input = in.nextLine().trim().replaceAll("  +", " ");
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int rightRotations = numbers[0];
            int arraySize = numbers[1];
            int[] array = new int[arraySize];
            System.arraycopy(numbers, 2, array, 0, array.length);
            int[] rotatedArray = rotateArrayRight(array, rightRotations);

            System.out.print("Case #" + (i+1) + ": ");
            for (int h = 0; h < rotatedArray.length; h++) {
                System.out.print(rotatedArray[h] + " ");
            }
            System.out.println("");
        }
    }
}
