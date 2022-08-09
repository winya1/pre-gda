https://coding-competitions-staging.appspot.com/codejam/round/0000000000a5a33f/0000000000a5a2bf <br>
<h2> Balanced Braces (week 7, assignment 2) </h2>
Instructions:

Read lines from System.in until there are no more lines.

For each line read, output "valid" or "invalid"

Each line consists of arbitrary characters. You can ignore all characters that are not braces. <br>

Braces include: <br>

 > "(", which is closed by ")" <br>
 > "[", which is closed by "]" <br>
 > "{", which is closed by "}" <br>
 > "<", which is closed by ">" <br>
 
Output "valid" if the braces on that line are correctly nested, so that each open brace is closed by its corresponding closing brace, and braces are nested "( ( () ) )", not interleaved: "( [ ) ]" <br>

For each line, output "valid" if every open symbol in the set "( [ { <" it has a matching corresponding closing symbol ") ] } >", and they are not interleaved; else output "invalid". <br>

>i.e, <br>

>"()[]" <br>
>is valid, <br>
>"([])" <br>
>is valid, <br>
>"(cite[24])" <br>
>is valid, <br>
>but <br>

> "([)]" <br>
> and <br>
> "(" <br>
>are invalid.<br>

You can implement this using a stack. One possible implementation uses a StringStack; another uses a Stack<Integer>. <br>

Copy your Stack implementation (or StringStack implementation) from assignment 1 or assignment 2 to here, and use it. <br>

One way to solve this is to write a function: <br>

> public static boolean isValid(String line, String opens, String closes) <br>
which takes a line of the input, and returns whether that line is balanced. <br>

Note that this method also takes two additional Strings, a list of open braces and a list of closed braces. <br>

It's helpful to be able to turn a String variable "line" into an array of char, which you can do with <br>

      line.toCharArray()
