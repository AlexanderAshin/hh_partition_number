package com.hh_partition_number;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n = 0, k = 0, i, j;
        Scanner in = new Scanner(System.in);
        while ((n < 1) || (n > 150) || (k < 1) || (k > 150)) {//������ �� ������������� ����� ��������
            System.out.print("N (1-150)= ");
            n = in.nextInt();//���� N
            System.out.print("K (1-150)= ");
            k = in.nextInt();// ���� K
        }
            int[][] p = new int[n + 1][k + 1];//���������� � ������������� �������
            for (i = 0; i < n; i++)
                p[i] = new int[k + 1];
            for (i = 1; i < n + 1; i++) // ���������� ���������� ��������� �����
                for (j = 1; j < k + 1; j++) {
                    if ((j == 1) || (i == j)) p[i][j] = 1;//��� k=1 ��� n=k ���-�� ��������� ����� 1
                    if (i < j) p[i][j] = 0; //��� n<k ���-�� ��������� ����� 1
                    if ((i > j) && (j != 1)) p[i][j] = p[i - 1][j - 1] + p[i - j][j];//��� n>k � k �� 1 P=P(n-1,k-1)+P(n-k,k) �������� ��� ���������� ����� �� �������
                }
            System.out.printf("P= %d", p[n][k]);//����� ����������
        }
    }
