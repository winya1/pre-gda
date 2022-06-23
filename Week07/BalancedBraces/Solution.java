import java.util.Scanner;

public class Solution {

   /**
    * Instructions:
    *
    * Read lines from System.in until there are no more lines.
    *
    * For each line read, output "valid" or "invalid"
    *
    * Each line consists of arbitrary characters. You can ignore all characters that are not braces.
    *
    *  Braces include:
    *  "(", which is closed by ")"
    *  "[", which is closed by "]"
    *  "{", which is closed by "}"
    *  "<", which is closed by ">"
    *
    * Output valid if the braces on that line are correctly nested,
    * so that each open brace is closed by its corresponding closing brace,
    * and braces are nested "( ( () ) )", not interleaved: "( [ ) ]"
    *
    * For each line, output "valid" if every open symbol in the set "( [ { <"
    * it has a matching corresponding closing symbol ") ] } >", and they are not interleaved;
    * else output "invalid".
    *
    * i.e,
    * "()[]"" is valid,
    * "([])"" is valid,
    * "(cite[24]) is valid,
    *
    * but "([)]" and
    * "(" are invalid.
    *
    * You can implement this using a stack.
    * One possible implementation uses a StringStack; another uses a Stack<Integer>.
    *
    * Copy your StringStack implementation (or Stack<T> implementation)
    * from assignment 1 to here, and use it.
    *
    * One way to solve this is to write a function:
    *     public static boolean isValid(String line, String opens, String closes)
    * which takes a line of the input, and returns whether that line is balanced.
    *
    * Note that this method also takes two additional Strings, a list of open braces and a list of closed braces.
    *
    * It's helpful to be able to turn a String variable "line" into an array of char, which you can do with
    *
    *      line.toCharArray()
    */
 

    /**
     * This is the Stack interface.
     * Do not modify it.
     */
    interface Stack<T> {
        /**
         * After calling push, t is the top element of this Stack. T can be any objects
         */
        void push(T t);

        /**
         * peek returns the top element of this Stack, leaving the Stack unchanged,
         * or if the Stack is empty throws a StackUnderflowException.
         */
        T peek();

        /**
         * pop remove the top element of this Stack, and returns that element,
         * or if the Stack is empty throws a StackUnderflowException.
         */
        T pop();

        /**
         *
         * @return true iff (if and only if) this Stack is empty, else false.
         */
        boolean isEmpty();

        /**
         * return the size of this Stack.
         */
        int size();
    }

    /**
     * This interface just fixes the generic type T as String
     * Do not modify it.
     */
    interface StringStack extends Stack<String> {
        // no body is necessary, as this interface inherits all members of the Stack super-interface
        // but to make it easier to read, we've copied the method names, and added the
        // @Override annotation to show they override the super-interface methods.
        // See the Stack super-interface, above, for the documentation of what each method does.

        @Override
        void push(String s);

        @Override
        String peek();

        @Override
        String pop();

        @Override
        int size();
    }
    public static class ListNode<T> {
        T value;
        ListNode<T> next;
        public ListNode(T obj) {
            this.value = obj;
            this.next = null;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }

        public T getData() {
            return value;
        }

        public ListNode<T> getNext() {
            return next;
        }
    }
    /**
     * Modify this StringStackImpl class, or write your own.
     */

    public static class StackImpl<T> {
        ListNode<T> head;
        int size;
        public StackImpl() {
            this.head = null;
            this.size = 0;
        }

        public void push(T obj) {
            this.size++; // increase the size by 1
            ListNode<T> newHead = new ListNode<T>(obj); //create a new head
            newHead.setNext(head); //set the new head as the next item of the list
            head = newHead; // set the new head as the new head
        }

        public T peek() {
            if (size > 0) {
                return head.getData();
            }
            return null;
        }


        public T pop() {
            if (size > 0) {
                T currentValue = head.getData(); //stores current head
                size--; //sizes down because you removed head
                head = head.getNext(); //skips current head so that the next node becomes head
                return currentValue;
            }
            return null;
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }
    }
    public static class StringStackImpl extends StackImpl<String> implements StringStack {
        /**
         * Constructor: initilalizes a new StringStackImpl instance.
         */
        //head -- push
        public StringStackImpl() {
            super();
        }
    }




   /**
    * Exercise your Stack
    * Read lines from System.in
    * For each line, output "valid" for every open symbol in the set "( [ { <"
    * it has a matching closing symbol ") ] } >", and they are not interleaved,
    * else output "invalid".
    *
    * i.e, "()[]"" is valid, "([])"" is valid, "(cite[24]) is valid,
    * but "([)]" and "(" are invalid
    *
    */
  
    public static void main(String[] args) {


        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] stringArray = line.split("(?!^)");

                if (isValid(stringArray)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }

            }

            }
        }




    // One possible way to implement a solution, or do it your way:
       public static boolean isValid(String[] stringArray) {
           StringStackImpl stack = new StringStackImpl();
           int countOpenings = 0; // to find out if there are 0 of these, then return false; isEmpty would be defaulted to 0 if there are no closings
           int countClosings = 0;// to count if there's a straggler closing 

           for (String str : stringArray) {
               if (str.equals("")) {
                   return true;
               }
               else if (str.equals("(") || str.equals("[") || str.equals("{") || str.equals("<")) {
                   stack.push(str);
                   countOpenings++;

               } else {
                   if (!stack.isEmpty()
                           && (((stack.peek().equals("(") && str.equals(")"))
                           || (stack.peek().equals("[") && str.equals("]"))
                           || (stack.peek().equals("{") && str.equals("}"))
                           || (stack.peek().equals("<") && str.equals(">"))))) {
                       stack.pop();
                   } else if (str.equals(")") || str.equals("]") || str.equals("}") || str.equals(">")) {
                       countClosings++;
                   }
               }
           }

           if (countOpenings == 0) {
               return false;
           } else if (countClosings > 0) {
               return false;
           } else {
               return stack.isEmpty();
           }
       }
}



