import java.util.Scanner;

class Solution {
    // Note the `static` keyword before the class definition: it is required.
    static class twoDPoint {
        private double x;
        private double y;
        public twoDPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Segment {
        private twoDPoint start;
        private twoDPoint end;

        public Segment(twoDPoint start, twoDPoint end) {
            this.start = start;
            this.end = end;
        }

        public double length() {
            return Math.sqrt(Math.pow((end.x - start.x),2) + Math.pow((end.y - start.y),2));
        }

    }

    static class Triangle {
        private twoDPoint firstPoint;
        private twoDPoint secondPoint;
        private twoDPoint thirdPoint;
        private Segment distanceFirstAndSecond;
        private Segment distanceSecondAndThird;
        private Segment distanceFirstAndThird;

        public Triangle(twoDPoint firstPoint, twoDPoint secondPoint, twoDPoint thirdPoint) {
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
            this.thirdPoint = thirdPoint;
            distanceFirstAndSecond = new Segment(this.firstPoint, this.secondPoint);
            distanceSecondAndThird = new Segment(this.secondPoint, this.thirdPoint);
            distanceFirstAndThird = new Segment(this.firstPoint, this.thirdPoint);
        }


        public double area() {
            return Math.abs(0.5*((firstPoint.x)*(secondPoint.y - thirdPoint.y) + (secondPoint.x)*(thirdPoint.y - firstPoint.y)
                    + thirdPoint.x*(firstPoint.y - secondPoint.y)));
        }
        
        public double perimeter() {
             return distanceFirstAndSecond.length() + distanceSecondAndThird.length() + distanceFirstAndThird.length();

        }

    }

    static class Rectangle {
        private twoDPoint firstPoint;
        private twoDPoint secondPoint;
        private twoDPoint thirdPoint;
        private twoDPoint fourthPoint;
        private Segment distanceFirstAndSecond;
        private Segment distanceSecondAndThird;
        private Segment distanceFirstAndThird;
        private Segment distanceFirstAndFourth;

        public Rectangle(twoDPoint firstPoint, twoDPoint secondPoint, twoDPoint thirdPoint) {
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
            this.thirdPoint = thirdPoint;
        }

        public double xSide() {
           return Math.max(firstPoint.x, Math.max(secondPoint.x, thirdPoint.x)) -
                   Math.min(firstPoint.x, Math.min(secondPoint.x, thirdPoint.x));

        }

        public double ySide() {
            return Math.max(firstPoint.y, Math.max(secondPoint.y, thirdPoint.y)) -
                    Math.min(firstPoint.y, Math.min(secondPoint.y, thirdPoint.y));

        }

        public double area() {
            return xSide()*ySide();
        }


        public double perimeter() {
            return 2*xSide() + 2*ySide();

        }

    }


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            String input = in.nextLine();
            String[] fragments = input.split(" ");

            twoDPoint first = new twoDPoint(Double.parseDouble(fragments[0]), Double.parseDouble(fragments[1]));
            twoDPoint second = new twoDPoint(Double.parseDouble(fragments[2]), Double.parseDouble(fragments[3]));
            twoDPoint third = new twoDPoint(Double.parseDouble(fragments[4]), Double.parseDouble(fragments[5]));

            Triangle triangle = new Triangle(first, second, third);
            Rectangle rectangle = new Rectangle(first, second, third);

            System.out.printf("Case #" + (i+1) + ": " + String.format("%.2f", triangle.area()) + " " + String.format("%.2f", triangle.perimeter())
            + " " + String.format("%.2f", rectangle.area()) + " " + String.format("%.2f", rectangle.perimeter()) + "\n");
        }
    }
}
