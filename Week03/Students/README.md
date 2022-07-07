<h2> Students </h2>
Given some information about the student, print this student's report card.

Define a class containing the following information about a student:

F: First name
L: Last name
G1: Grade for the first assignment
G2: Grade for the second assignment
G3: Grade for the third assignment
Define a member function computing the average grade for all assignments. Define a member function returning the full name of the student. Define a member function that outputs the report card in the following format:

L, F: Grades: [G1, G2, G3] (avg: Gavg).

<h2> Input </h2>
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing two strings and three integer numbers: the F, L, G1, G2, G3.

<h2> Output </h2>
For each test case, output one line containing Case #t: L, F: Grades: [G1, G2, G3] (avg: Gavg), where t is the test case number other fields are described in the statement above. The average must be output rounded to one decimal digit after the comma (using "%.1f" format string in System.out.printf).

