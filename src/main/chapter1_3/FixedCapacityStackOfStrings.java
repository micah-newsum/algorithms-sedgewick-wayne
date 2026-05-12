package main.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
    private final String[] a;
    private int n;

    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public void push(String s) {
        a[n++] = s;
    }

    public String pop() {
        return a[--n];
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
       FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
       while (!StdIn.isEmpty()) {
           String item = StdIn.readString();
           if (!item.equals("-")) {
               stack.push(item);
           }
           else if (!stack.isEmpty()) {
               StdOut.print(stack.pop() + " ");
           }
       }
       StdOut.println("("+stack.size()+" left on stack)");
    }
}
