package com.chen.p;

import java.util.Arrays;
import java.util.Random;

//        1. Создать 2-мерный массив (матрица) M*N и заполнить его случайными числами.
//        Отсортировать числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число,
//        справа от него следующее по значению, итд, в правом нижнем углу самое большое.

public class task1 {

    private static final Random RANDOM = new Random();
    private static final int X = RANDOM.nextInt(8) + 2;
    private static final int Y = RANDOM.nextInt(8) + 2;

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(X, Y);
        print(matrix);
        System.out.println("");
        print(matrixSort(matrix));
    }

    private static int[][] generateMatrix(int X, int Y) {
        int[][] matrix = new int[X][Y];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                matrix[i][j] = RANDOM.nextInt(100);
            }

        }
        return matrix;
    }

    private static void print(int[][] matrix) {
        System.out.println(matrix.length + "x" + matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static int[][] matrixSort(int[][] matrix) {
        // k = j * Y + i формула приведенного индекса
        // сортировка пузырьком
        int n = X * Y;
        for (int i = 0; i < n - 1; i++) {
            for (int key = 0; key < n - i - 1; key++) {
                int a = key / Y;
                int b = key % Y;
                int c = (key + 1) / Y;
                int d = (key + 1) % Y;
                if (matrix[a][b] > matrix[c][d]) {
                    int temp = matrix[a][b];
                    matrix[a][b] = matrix[c][d];
                    matrix[c][d] = temp;
                }
            }
        }
        return matrix;
    }

}


