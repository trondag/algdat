package com.company;

import java.lang.reflect.Array;

public class CircularQueue<E>  {
    private E[] queue;
    private int front = 0;
    private int rear = 0;
    private int MAX_SIZE = 0;

    public CircularQueue(Class<E> c, int size){
        queue =  (E[]) (new Object[size]);
        MAX_SIZE = size;
    }
    public void enqueue(E element) {
        if (this.size() == MAX_SIZE){
            System.out.println("Queue is full");
           return;
        }
        rear = (rear) % MAX_SIZE;
        queue[rear] = element;
        rear++;
    }

    public E dequeue() throws EmptyCollectionException {
        E element = queue[front];
        front = (front + 1) % MAX_SIZE;
        return element;
    }

    public E first() throws EmptyCollectionException {
        return queue[front];
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public int size() {
        return rear - front;
    }
}
