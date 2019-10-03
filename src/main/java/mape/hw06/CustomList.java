package mape.hw06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private T key;
        private Node<T> prev;
        private Node<T> next;

        Node(T key) {
            this.key = key;
        }
    }

    // construct an empty list
    public CustomList() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the node to the front
    public void addFirst(T key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node<T> node = new Node<>(key);
        if (size == 0) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // add the node to the back
    public void addLast(T key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node<T> node = new Node<>(key);
        if (size == 0) {
            head = node;
            tail = node;
        }
        else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(T key, int index) {
        validateIndex(index);

        if (index == size) {
            addLast(key);
        } else if ( index == 0 ) {
            addFirst(key);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<T> node = new Node<>(key);
            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index: index = " + index + ", size = " + size);
        }
    }

    public T get(int index) {
        validateIndex(index);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.key;
    }

    private class CustomListIterator implements Iterator<T> {
        private Node<T> current;


        CustomListIterator(Node<T> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T result = current.key;
            current = current.next;
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    // return an iterator over items in order from front to back
    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator(head);
    }
}
