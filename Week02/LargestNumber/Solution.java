import java.util.ArrayList;
import java.util.Scanner;

public class Solution {  
  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();

    while(input.hasNextInt()) {
      list.add(input.nextInt());
     }

     int greatest = list.get(1);


    for(int i = 1; i < list.size(); i++) {
      int number = list.get(i);
      if (greatest < number) {
        greatest = number;
     }
    }

    System.out.println(greatest);

    }
}
