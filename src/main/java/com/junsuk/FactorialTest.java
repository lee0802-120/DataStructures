package com.junsuk;

public class FactorialTest {

    static void main(String[] args) {
        int number = 10; // 계산할 팩토리얼 숫자 (5! = 5 x 4 x 3 x 2 x 1)
        // 팩토리얼 결과 출력
        long result = factorial(number);
        IO.println(number + "! = " + result);
        long factorial = 1;
        for (int i = number; i >= 1 ; i--) {
            factorial = factorial * i;
        }
        IO.println(number + "! = " + factorial);
    }

    // n! = n * (n-1)!, (n-1)! = (n-1) * (n-2)!, (n-2)! = (n-2) * (n-3)!
    public static long factorial(int n) {
        // 기본 단계 (Base Case): 0!과 1!은 항상 1입니다.
        if (n <= 1) return 1;
        // 재귀 단계 (Recursive Step): n * (n - 1)! == n * (n-1) * (n-2)!
        return n * factorial(n - 1);
    }

}
