package com.variable;

public class variable {

    public static int and(int a, int b) {
        return a & b;
    }

    public static int or(int a, int b) {
        return a | b;
    }

    public static int xor(int a, int b) {
        return a ^ b;
    }

    public static int not(int a) {
        return ~a;
    }

    public static int leftShift(int a, int b) {
        return a << b;
    }

    public static int rightShift(int a, int b) {
        return a >> b;
    }

    // 부호 없는 오른쪽 시프트
    public static int shiftLeftWithNoSign(int a, int b) {
        return a >>> b;
    }

}
