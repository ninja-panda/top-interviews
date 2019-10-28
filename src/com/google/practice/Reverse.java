package com.google.practice;

public class Reverse {

    public static void main(String[] args) {
        int x = 121;
        System.out.println("Reverse of " + x + " is :" + reverse(x));
        x = -120;
        System.out.println("Reverse of " + x + " is :" + reverse(x));
        x = -50;
        System.out.println("Reverse of " + x + " is :" + reverse(x));
        x = 78;
        System.out.println("Reverse of " + x + " is :" + reverse(x));
    }

    public static int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        boolean isNeg = x < 0 ? true : false;
        if (isNeg) x = -x;

        int reverse = 0;
        while (x > 0) {
            int remainder = x % 10;
            if (reverse > Integer.MAX_VALUE / 10) {
                reverse = 0;
                break;
            }
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        if (isNeg) reverse = -reverse;
        return reverse;
    }
}
