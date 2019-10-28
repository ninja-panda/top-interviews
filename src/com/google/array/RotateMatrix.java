package com.google.array;

class MatrixSolution {

    public void rotateMatrix(int[][] matrix) {
        transpose(matrix);
        System.out.println("Matrix After Transpose");
        print(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixSolution matrixSolution = new MatrixSolution();
        System.out.println("Matrix Before Rotation>>");
        matrixSolution.print(matrix);
        matrixSolution.rotateMatrix(matrix);
        System.out.println("Matrix After 90 Degree Rotation>>");
        matrixSolution.print(matrix);
    }

}
