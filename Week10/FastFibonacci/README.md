https://coding-competitions-staging.appspot.com/codejam/round/0000000000a5c424/0000000000a5c4dc <br>
<h2> [OPTIONAL] Fast Fibonacci Numbers </h2>
Fibonacci number sequence is defined by a function F(n), which accepts an integer and returns an integer. The function is defined in the following way:

F(n) = 0, if n == 0;

F(n) = 1, if n == 1

F(n) = F(n-1) + F(n-2), otherwise.

However, implementing this as a recursive function in the programming language results in a very slow program, which repeats a lot of computations. The linked article proposes a techique that makes the computation faster: memoization. The techinque uses HashMaps that were introduced during the week 9.

Implement static class Fib, which contains HashMap<Integer, Long> member variable and long compute(int n) function, which recursively computes the n-th Fibonacci number. The compute function should put the computed value into the HashMap before returning it, and should check if the value is already in the HashMap before starting the recursive computation.

Note: there is a different technique that allows fast recursive Fibonacci numbers computation: Tail Recursion. It is also an acceptable solution for this problem, but we recommend memoization as it is more frequently used for real-world problems.

<h2> Input </h2>
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a single integer number N: the number to call the F function.

<h2> Output </h2>
For each test case, output one line containing Case #x: y, where x is the test case number (starting at 1), and y is the corresponding Fibonacci number.
