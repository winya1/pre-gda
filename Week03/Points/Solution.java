import java.util.Scanner;

class Solution {
    
    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance() {
            return Math.sqrt((x*x) + (y*y));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
  
        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            String input = in.nextLine();
            String[] fragments = input.split(" ");
            Point testOne = new Point(Integer.parseInt(fragments[0]), Integer.parseInt(fragments[1]));
            Point testTwo = new Point(Integer.parseInt(fragments[2]), Integer.parseInt(fragments[3]));

            if (testOne.distance() < testTwo.distance()) {
                System.out.println("Case #" + (i+1) + ": " + fragments[0] + " " + fragments[1]);
            }
            if (testOne.distance() > testTwo.distance()) {
                System.out.println("Case #" + (i+1) + ": " + fragments[2] + " " + fragments[3]);
            }
        }
    }
}
