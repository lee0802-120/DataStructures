package com.junsuk.list;

import com.junsuk.vo.ListInterface;
import com.junsuk.vo.Node;

public class MyLinkedList<E extends Comparable<E>> implements ListInterface<E> {
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
        } else {
            throw new ArrayIndexOutOfBoundsException("The index value has been exceeded.");
        }
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
            } else {
                return false;
            }
        }
        return false;
    }

    public E get(int i) {
        if (i >= 0 && i <= numItems - 1)
            return getNode(i).item;
        else return null;
    }

    public void set(int i, E x) {
        if (i >= 0 && i <= numItems - 1)
            getNode(i).item = x;
        else {
            throw new IndexOutOfBoundsException();
        }
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

    public MyLinkedList<E> subList(int from, int to) {
        if (from < 0 || to > numItems - 1 || from > to) // 범위를 벗어나면 예외 처리.
            throw new IndexOutOfBoundsException("from: " + from + "to: " + to);

        MyLinkedList<E> result = new MyLinkedList<>(); // 새 객체를 만든다.
        Node<E> curr = getNode(from);
        for (int i = from; i <= to; i++) {
            result.append(curr.item);
            curr = curr.next;
        }
        return result;
    }

    public int getMax() {
        if (numItems == 0) return NOT_FOUND;

        Node<E> curr = head.next; // 더미 다음 = 0번 노드
        E max = curr.item; // 0번 원소를 일단 최대값으로
        int idx = 0;

        for (int i = 0; i < numItems; i++) {
            if (curr.item.compareTo(max) > 0) { // curr.item > max
                max = curr.item;
                idx = i; // 노드가 아니라 '몇 번쨰인지'를 기억
            }
            curr = curr.next; // 다음 노드로 이동 (빠뜨리면 같은 노드만 봄)
        }
        return idx;
    }

    public int getMin() {
        if (numItems == 0) return NOT_FOUND; // numItems(인덱스) 0이라면 NOT_FOUND 값을 반환

        Node<E> curr = head.next;
        E min = curr.item;
        int idx = 0;

        for (int i = 0; i < numItems; i++) {
            if (curr.item.compareTo(min) < 0) {
                min = curr.item;
                idx = i;
            }
            curr = curr.next;
        }
        return idx;
    }

    public MyLinkedList<E> cloneList() {
        return this.subList(0, numItems - 1);
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++)
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
