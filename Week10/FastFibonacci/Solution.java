import java.util.*;


class Solution {

    static class Fib {
        Map<Integer, Long> memo;
        public Fib() {
            memo = new HashMap<>();
        }

        public long compute(int n) {
            // base case
            if (n < 0) {
                return -1;
            }
            if (n == 0 || n == 1) {
                return n;
            }

            // memoization
            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            //recursion
            long ret = compute(n-1) + compute(n-2);
            memo.put(n, ret);
            return ret;
        }
    }


    public static void main(String[] args) {
        Fib f = new Fib();
        Scanner in = new Scanner(System.in);

        int caseInput = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseInput; i++) {
            int input = Integer.parseInt(in.nextLine());

            System.out.println("Case #" + (i + 1) + ": " + f.compute(input));
        }
    }
}
