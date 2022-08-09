https://coding-competitions-staging.appspot.com/codejam/round/0000000000a5c424/0000000000a5c426 <br>
<h2> Normal Polish Notation </h2>
"Normal Polish Notation", "Polish Notation", "NPN", "PN", or "prefix" form, is a mathematical expression where operators ("+" addition, "-" subtraction, "*" multiplication, "/" division, and "^" exponentiation) come before (prefix) the operands they work on.

An NPN expression is either:

<br> A number. The expression result is equal to the number.
<br> An operation ("+", "-", "*", "/", or "^"), followed by two other expressions. The result is equal to the result of applying the operation to the results of the first and the second expressions.


NPN expressions can be evaluated using recursive function private static double npn(Scanner in), which does the following:

Read the next input token. If it is a number, return its value.
<br> Otherwise, the token is an operation. Call npn(in) twice to evaluate the first and the second expression, then apply the operation to their results.
Tip
Normal Polish Notation input format is very similar to the input format of Reverse Polish Notation, that was in assignment 3 of week 7. You can reuse the old code handling the input, and write new code to compute the result.

Exponentiation in Java can be done using the Math.pow() function: a ^ b equals to Math.pow(a, b).

<h2> Input </h2>
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is an NPN expression that has to be evaluated.

<h2> Output </h2>
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1), and y is the result of the corresponding expression. Output the result with 1 digit after the comma (using the .1f format specifier).
