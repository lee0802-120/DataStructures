package com.junsuk.list;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.append(2);
        list.append(5);
        list.append(4);
        list.append(8);
        list.append(6);
        list.append(7);
        list.append(1);
        IO.println("가장 큰 값: " + list.get(list.getMax()));
        IO.println("가장 작은 값: " + list.get(list.getMin()));


        MyArrayList<Integer> list2 = list.cloneList();
        list2.append(2);
        list2.append(5);
        list2.append(4);
        list2.append(8);
        list2.append(6);
        list2.append(7);
        list2.append(1);
        IO.println("가장 큰 값: " + list2.get(list.getMax()));
        IO.println("가장 작은 값: " + list2.get(list.getMin()));
    }
}
