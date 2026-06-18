package main.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// FIFO
public class Queue<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Node next;
        Item item;
    }

   public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
   }

   public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
   }

   public boolean isEmpty() { return n == 0; }

    public int size() { return n;}

   public static void main(String[] args) {
       Queue<String> queue = new Queue<>();
       while (!StdIn.isEmpty()) {
           String item = StdIn.readString();
           if (!item.equals("-")) {
               queue.enqueue(item);
           } else if (!queue.isEmpty()) {
               StdOut.print(queue.dequeue() + " ");
           }
       }
       StdOut.println("(" + queue.size() + " left on stack)");
   }
}
