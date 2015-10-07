package com.hh_partition_number;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n = 0, k = 0, i, j;
        Scanner in = new Scanner(System.in);
        while ((n < 1) || (n > 150) || (k < 1) || (k > 150)) {//защита от некорректного ввода значений
            System.out.print("N (1-150)= ");
            n = in.nextInt();//ввод N
            System.out.print("K (1-150)= ");
            k = in.nextInt();// ввод K
        }
            int[][] p = new int[n + 1][k + 1];//объ€вление и инициализаци€ массива
            for (i = 0; i < n; i++)
                p[i] = new int[k + 1];
            for (i = 1; i < n + 1; i++) // вычисление количества разбиений числа
                for (j = 1; j < k + 1; j++) {
                    if ((j == 1) || (i == j)) p[i][j] = 1;//при k=1 или n=k кол-во разбиений равно 1
                    if (i < j) p[i][j] = 0; //при n<k кол-во разбиений равно 1
                    if ((i > j) && (j != 1)) p[i][j] = p[i - 1][j - 1] + p[i - j][j];//при n>k и k не 1 P=P(n-1,k-1)+P(n-k,k) значени€ дл€ вычислений берем из массива
                }
            System.out.printf("P= %d", p[n][k]);//вывод результата
        }
    }
