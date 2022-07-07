import java.util.Scanner;

class Solution {
    // Note the `static` keyword before the class definition: it is required.
    static class Student {
        String firstName;
        String lastName;
        float firstGrade;
        float secondGrade;
        float thirdGrade;

        public Student(String firstName, String lastName, float firstGrade, float secondGrade, float thirdGrade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.firstGrade = firstGrade;
            this.secondGrade = secondGrade;
            this.thirdGrade = thirdGrade;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            String input = in.nextLine();
            String[] fragments = input.split(" ");
            Student student = new Student(fragments[0], fragments[1], Float.parseFloat(fragments[2]), Float.parseFloat(fragments[3]), Float.parseFloat(fragments[4]));
            float average = (student.firstGrade + student.secondGrade + student.thirdGrade)/3;
            System.out.printf("Case #" + (i+1) + ": " + fragments[1] + ", " + fragments[0] +
                    ": Grades: [" + fragments[2] + ", " + fragments[3] + ", " + fragments[4] + "]" + " (avg: " + String.format("%.1f", average) + ")" + "\n");
        }
    }
}
