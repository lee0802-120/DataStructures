package com.junsuk.list;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
//        myLinkedList.append(1);
//        myLinkedList.append(2);
//        myLinkedList.append(3);
//        myLinkedList.append(4);
//        myLinkedList.append(5);
//        myLinkedList.append(6);
//        myLinkedList.append(7);

        myLinkedList.append(10);
        myLinkedList.append(1);
        myLinkedList.append(22);
        myLinkedList.append(42);
        myLinkedList.append(54);
        myLinkedList.append(14);
        myLinkedList.append(70);
        myLinkedList.append(41);
        myLinkedList.append(9);
        myLinkedList.append(110);
        myLinkedList.append(15);
        myLinkedList.append(12);
        myLinkedList.append(13);
        myLinkedList.append(25);

        IO.println(myLinkedList.toString());
        IO.println(myLinkedList.get(myLinkedList.getMax()));
    }

}
