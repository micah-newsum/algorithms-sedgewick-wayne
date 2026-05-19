package main.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;

    public ResizingArrayStack() {
        this.n = 1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == a.length;
    }

    public int  size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    public Item pop() {
        Item item = a[--n];
        a[n] = null; // Avoid loitering
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
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

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = n - 1;

        public boolean hasNext() { return i >= 0; }

        public Item next() { return a[i--]; }

        public void remove() { throw new UnsupportedOperationException(); }
    }
}
