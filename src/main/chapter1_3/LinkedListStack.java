package main.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

// LIFO stack
public class LinkedListStack<Item> {
    private Node first;
    private int n = 0;

    private class Node {
        private Node next;
        private Item item;
    }

    private class ListIterator implements Iterator<Item> {
        Node current;

        public ListIterator() {
            current = first;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }

    public LinkedListStack() {
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");

        // Iterator client
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
