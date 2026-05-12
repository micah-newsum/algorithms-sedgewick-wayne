package main.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {
    private final Item[] a;
    private int n;

    public FixedCapacityStack(int capacity) {
        a = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public Item pop() {
        return a[--n];
    }

    public void push(Item item) {
        a[n++] = item;
    }

    public int  size() {
        return n;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop()+ " ");
            }
        }
        StdOut.println("("+stack.size()+" left on stack)");
    }
}
