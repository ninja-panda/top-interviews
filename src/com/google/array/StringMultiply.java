package com.google.array;

class StringMultiplySolution {

    public String multiply(String num1, String num2) {
        long firstNumber = num1 == null ? 0 : parseLong(num1);
        long secondNumber = num2 == null ? 0 : parseLong(num2);
        long multiplication = firstNumber * secondNumber;
        System.out.println("Multiplication: " + multiplication);
        return multiplication + "";
    }

    public long parseLong(String num) {
        if (num == null) {
            return 0;
        }
        char[] charArray = num.toCharArray();
        int len = (charArray.length - 1);
        long result = 0;
        for (int i = 0; i < charArray.length; i++) {
            int current = charArray[i] - '0';
            long radix = (long) Math.pow(10, len);
            result = result + current * radix;
            len--;
        }
        System.out.println("Number: " + result);
        return result;
    }
}

public class StringMultiply {

    public static void main(String[] args) {
        StringMultiplySolution stringMultiplySolution = new StringMultiplySolution();
        String num1 = "498828660196";
        String num2 = "840477629533";
        System.out.println(stringMultiplySolution.multiply(num1, num2));
    }
}
