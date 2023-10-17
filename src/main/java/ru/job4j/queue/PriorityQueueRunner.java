package ru.job4j.queue;

import java.util.PriorityQueue;

public class PriorityQueueRunner {
    public static void main(String[] args) {
        PriorityQueue<String> stringsQueue = new PriorityQueue<>();
        stringsQueue.offer("f");
        stringsQueue.offer("a");
        stringsQueue.offer("s");
        stringsQueue.offer("e");
        printStringElements(stringsQueue);

        PriorityQueue<Transaction> transactions = new PriorityQueue<>(new TransactionSortDescByAmount());
        transactions.offer(new Transaction(1, "number_1", 100));
        transactions.offer(new Transaction(2, "number_2", 1000));
        transactions.offer(new Transaction(3, "number_3", 85));
        transactions.offer(new Transaction(4, "number_4", 550));
        printTransactionElements(transactions);
    }

    public static void printStringElements(PriorityQueue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }

    public static void printTransactionElements(PriorityQueue<Transaction> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }
}
