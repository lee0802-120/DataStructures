package com.junsuk.list;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringArrayList.add("wish " + i); // 맨 뒤에 추가(append)
        }

        for(int i = 0; i < stringArrayList.size(); i++) { // size() : list가 저장할 수 있는 원소 수
            IO.println(stringArrayList.get(i));
        }

        for (int i = 0; i < stringArrayList.size(); i++) {

        }
    }

}
