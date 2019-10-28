package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class PlusOneToArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = plusOne(a);
        print(b);

        int[] a_1 = {9, 9};
        int[] b_1 = plusOne(a_1);
        print(b_1);

        int[] a_2 = {9};
        int[] b_2 = plusOne(a_2);
        print(b_2);

        int[] a_3 = {8, 9, 9, 9};
        int[] b_3 = plusOne(a_3);
        print(b_3);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != (arr.length - 1)) {
                System.out.print(" - ");
            } else {
                System.out.println();
            }
        }
        System.out.println("--------------");
    }

    public static int[] plusOne(int[] digits) {

        if (digits == null) {
            return new int[1];
        }
        reverseArray(digits);
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
            int current = 0;
            if (i == 0) {
                current = digits[i] + 1;
            } else {
                current = digits[i] + carry;
            }
            if (current < 10) {
                result.add(current);
                carry = 0;
            } else {
                carry = current / 10;
                int remainder = current % 10;
                result.add(remainder);
            }
        }
        if (carry > 0) {
            result.add(carry);
        }
        digits = result.stream().mapToInt(i -> i).toArray();
        reverseArray(digits);
        return digits;
    }

    private static void reverseArray(int[] digits) {
        for (int i = 0, j = (digits.length - 1); i < j; i++, j--) {
            int temp = digits[i];
            digits[i] = digits[j];
            digits[j] = temp;
        }
    }
}
