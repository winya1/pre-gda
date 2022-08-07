import java.util.*;


class Solution {
    static void sort(int arr[]) {
        int n = arr.length;
   
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            System.out.println("Current value: " + key);
            int j = i - 1;
            // if the value before the key is greater than the key, then move that value to the next position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                System.out.println(Arrays.toString(arr));
                j = j - 1;
            }
          // if the key is greater 
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
        System.out.print("Sorted: ");
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int caseInput = Integer.parseInt(in.nextLine());

        for (int i = 0; i < caseInput; i++) {
            System.out.println("Case #" + (i + 1) + ":");
            int arraySize = Integer.parseInt(in.nextLine());
            String arrayElements = in.nextLine();
            int[] array = Arrays.stream(arrayElements.split(" ")).mapToInt(Integer::parseInt).toArray();
            sort(array);

        }
    }
}
