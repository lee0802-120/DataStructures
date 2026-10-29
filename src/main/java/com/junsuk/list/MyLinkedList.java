package com.junsuk.list;

import com.junsuk.vo.ListInterface;
import com.junsuk.vo.Node;

public class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;
    private final int NOT_FOUND = -1;

    public MyLinkedList() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    public void add(int index, E x) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(x, prevNode.next);
            prevNode.next = newNode;
            numItems++;
        } else {/* 예외 처리 */}
    }

    public void append(E x) {
        Node<E> prevNode = head;
        while (prevNode.next != null)
            prevNode = prevNode.next;
        Node<E> newNode = new Node<>(x, null);
        prevNode.next = newNode;
        numItems++;
    }

    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else
            return null;
    }

    public boolean removeItem(E x) {
        Node<E> currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            Node<E> prevNode = currNode;
            currNode = prevNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) {
                prevNode = currNode.next;
                numItems--;
                return true;
            }
        }
        return false; // 이부분이 뭔가 이상함.
    }

    public E get(int i) {
        if (i >= 0 && i <= numItems - 1)
            return getNode(i).item;
        else return null;
    }

    public void set(int i, E x) {
        if (i >= 0 && i <= numItems - 1)
            getNode(i).item = x;
        else { /* 예외 처리 */ }
    }

    public int indexOf(E x) {
        Node<E> currNode = head;
        for (int i = 0; i < numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable)(currNode.item)).compareTo(x) == 0) return i;
        }
        return NOT_FOUND;
    }

    public int size() {
         return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        numItems = 0;
        head = new Node(null, null);
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i < index; i++)
                currNode = currNode.next;
            return currNode;
        } else
            return null;
    }

    public String toString() {
        String str = "[";
        Node curr = head.next;
        for (int i = 0; i < numItems; i++) {
            str += curr.item;
            if (i < numItems - 1) str += ",";
            curr = curr.next;
        }
        return str + "]";
    }
}
