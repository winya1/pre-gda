https://coding-competitions-staging.appspot.com/codejam/round/0000000000a563a6/0000000000a5844f <br>
<h2> Rotate </h2>
Right rotation of an array means rotating the array elements towards the end of the array, putting the last element at the beginning of the array. For example:

Original array: 1 2 3 4 5.

Original array rotated right: 5 1 2 3 4 (the first element went to the second position, the second element -- to the third position, ..., the last element went to the first position).

Original array rotated right two times: 4 5 1 2 3.

Write a function that performs right rotation of an array the given number of times.

Tip: The TL verdict means that the solution needs too much time to solve the task. If you are getting this verdict, consider making the solution more efficient. Some rotations can be skipped, because rotating an array of size N N times does not change the array.

<h2> Input </h2>
The first line of the input contains T: the number of test cases. T test cases follow. <br>

Each test case is a line containing R: the number of right rotations to perform, N: the size of the array, and N integers: the elements of the array.

<h2> Output </h2>
For each test case, output one line containing Case #x: A1...An, where x is the test case number (starting from 1), and A1...An are the elements of the array after rotation.
