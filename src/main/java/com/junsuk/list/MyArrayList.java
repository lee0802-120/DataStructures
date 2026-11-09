package com.junsuk.list;

import com.junsuk.vo.ListInterface;

public class MyArrayList<E extends Comparable<E>> implements ListInterface<E> {
    private E[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private static final int NOT_FOUND = -1;

    public MyArrayList() {  // 생성자 1
        item = (E[]) new Integer[DEFAULT_CAPACITY]; // 초기값 지정안하면 상수값을 가져와서 적용. (최대 배열수 지정.)
        numItems = 0;
    }

    public MyArrayList(int n) {  // 생성자 2
        item = (E[]) new Integer[n]; // 이건 사용자 지정.
        numItems = 0;
    }

    public void add(int index , E x) {
        if (numItems >= item.length || index <0 || index> numItems) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = numItems-1; i >= index; i--)
                item[i+1] = item[i];   // shift right
            item[index] = x;
            numItems++;
        }
    }

    public void append(E x) {
        if (numItems >= item.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else
            item[numItems++] = x;
    }

    public E remove(int k) {  // 리턴값 추가
        if (isEmpty() || k < 0 || k > numItems-1)
            return null;
        else {
            E tmp = item[k];
            for (int i = k; i <= numItems-2; i++)
                item[i] = item[i+1];   // shift left
            numItems--;
            return tmp;
        }
    }

    public boolean removeItem(E x) {
        int k = 0;
        while (k < numItems && item[k] != x)
            k++;
        if (k == numItems) return false;
        else {
            for (int i = k; i <= numItems-2; i++)
                item[i] = item[i+1];   // shift left
            numItems--;
            return true;
        }
    }

    public E get(int i) {
        if (i >= 0 && i <= numItems - 1)
            return item[i];
        else return null;
    }

    public void set(int i, E x) {
        if (i >= 0 && i <= numItems-1)
            item[i] = x;
        else {
            throw new ArrayIndexOutOfBoundsException("인덱스를 초과 했습니다.");
        }
    }

    public int indexOf(E x) {
        int i = 0;
        while (i < numItems && item[i] != x)
            i++;
        if (i == numItems) return NOT_FOUND;
        else return i;  // x = item[i]는 i번 원소
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }

    public int getMax() {
        if (numItems == 0) return NOT_FOUND;

        E max = item[0];
        int idx = 0;
        for (int i = 0; i < numItems; i++) {
            if (item[i].compareTo(max) > 0) {
                max = item[i];
                idx = i;
            }
        }
        return idx;
    }

    public int getMin() {
        if (numItems == 0) return NOT_FOUND;

        E min = item[0];
        int idx = 0;
        for (int i = 0; i < numItems; i++) {
            if (item[i].compareTo(min) < 0) {
                min = item[i];
                idx = i;
            }
        }
        return idx;
    }

    public MyArrayList<E> subList(int from, int to) {
        if (from < 0 || to > numItems - 1 || from > to)
            throw new IndexOutOfBoundsException("from: " + from + "to: " + to);

        MyArrayList<E> result = new MyArrayList<>();
        for (int i = from; i <= to; i++) {
            result.append(item[i]);
        }

        return result;
    }

    public MyArrayList<E> cloneList() {
        return this.subList(0, numItems - 1);
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < numItems; i++) {
            str += item[i];
            if (i < numItems - 1) str += ","; // i 가 더크면 안함.
        }
        return str + "]";
    }

}
