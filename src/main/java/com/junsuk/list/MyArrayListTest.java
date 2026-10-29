package com.junsuk.list;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        list.add(4,5);
        list.add(5,6);
        list.add(6,7);

//        list.append(1);
//        list.append(2);
//        list.append(3);
//        list.append(4);
//        list.append(5);
//        list.append(6);
//        list.append(7);

        System.out.println(list.toString());
        // 그냥 add와 append의 차이를 실험하는 코드.
    }
}
