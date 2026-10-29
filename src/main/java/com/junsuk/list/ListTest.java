package com.junsuk.list;

public class ListTest {
    public static void main(String[] args) {
        String[] strings = new String[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "Wish" + i;
        }

        String[] nine = new String[9];
        for (int i = 0; i < nine.length; i++) {
            if (i != 4)
                nine[i] = strings[i];
        }

        for (int i = 0; i < strings.length; i++) {
            IO.println(strings[i] + "을 이루다.");
        }

        for (int i = 0; i < nine.length; i++) {
            IO.println(nine[i] + "을 이루다.");
        }
    }
}
