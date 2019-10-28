package com.google.array;

public class NumberPalindrome {

    public static void main(String[] args) {
        int x = 121;
        System.out.println("Is the number " + x + " is a Palindrome :" + isPalindrome(x));
        x = -123321;
        System.out.println("Is the number " + x + " is a Palindrome :" + isPalindrome(x));
        x = -5;
        System.out.println("Is the number " + x + " is a Palindrome :" + isPalindrome(x));
        x = 78;
        System.out.println("Is the number " + x + " is a Palindrome :" + isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        int reverse = reverse(x);
        return reverse == x;
    }

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isNegativeNumber = x < 0 ? true : false;
        if (isNegativeNumber) {
            x = -x;
        }
        int remainder = 0;
        int reverse = 0;
        while (x > 0) {
            remainder = x % 10;
            x = x / 10;
            if (reverse > Integer.MAX_VALUE / 10) {
                reverse = 0;
                break;
            }
            reverse = reverse * 10 + remainder;
        }
        if (isNegativeNumber) {
            reverse = -reverse;
        }
        return reverse;
    }
}
