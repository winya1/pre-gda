<h2> Insertion Sort </h2>
Insertion sort is one of the common "inefficient" sorts - sorts that are O(n^2) in the worst case. However, insertion sort is helpful to know because it is actually quite efficent for nearly-sorted data. For example, if you have a list of alphabetized student names and you want to add a new student, insertion sort is a great option.

</br> For this task, implement insertion sort with one added step: print the array each time you shift a value or put a value in its proper place. Your output will show each step taken when sorting the array.

<h2> Input </h2>
The first line of the input contains T: the number of test cases

</br> Each test case consists of two lines: the first line is the size of the array, and the second line contains the elements of the array separated by spaces. As a tip, this will allow you to read in the size of the array and create a new array like so: int[] input = new int[size]. Next, use a loop and in.nextInt() to read in each array element - you already have the size, so you can determine when to stop iterating.

<h2> Output </h2>
For each test case, output one line containing Case #x:, where x is the test case number (starting at 1), followed by a line for each step in the sort. Use Arrays.toString() to print the array.

</br> You will want to print in the following cases: 1. Print the current value you are sorting into the proper place 2. Print the array each time you shift a value 3. Print the array after you place the current value in its proper place
