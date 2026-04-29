package main.chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                Double val = vals.pop();
                String op  = ops.pop();
                if (op.equals("+")) val = val + vals.pop();
                if (op.equals("-")) val = val - vals.pop();
                if (op.equals("*")) val = val * vals.pop();
                if (op.equals("/")) val = val / vals.pop();
                if (op.equals("sqrt")) val = Math.sqrt(vals.pop());
                vals.push(val);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
