package com.company;

import java.util.Scanner;

public class gauss {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nЗавдання 1:");

        double[][] matrix = {
                {1, 0, 1, 0, 2},
                {-10, 1, -6, 1, -16},
                {169, -10, 25, -6, 198},
                {0, 169, 0, 25, -144}
        };
        double[][] result = task11(matrix);
        task13(matrix, 1);
        task13(result, 2);
        task13(task12(result), 3);

        System.out.println("\nЗавдання 2:");
        int[] n = new int[3];
        for(int i=0;i!=n.length;i++){
            System.out.printf("Введіть %d натуральне число: ",i+1);
            n[i]= scan.nextInt();
        }
        for(int i=0;i!=n.length;i++){
            System.out.printf("Сума дільників числа %d: %d\n",n[i],task2(n[i]));
        }
    }

/*МЕТОДИ ДЛЯ РГР*/


    public static double[][] task11(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for(int i=0;i!= matrix.length;i++){
            int j=0;
            while(j!=matrix[i].length){
                result[i][j]=matrix[i][j];
                j++;
            }
        }
        double dil;
        int s=0,k=0,l=0;
        for(int i=0;i!=result.length;i++){
            while (l!=result[i].length){
                if(result[i][0]==0){
                    if(i==0){
                        for(int r=0;r!=result[i].length;r++)
                            result[i][r]+=result[i+1][r];
                    }else if(i == result.length-1){
                        for(int r=0;r!=result[i].length;r++)
                            result[result.length-1][r]+=result[result.length-2][r];
                    }
                }
                l++;
            }
        }
        for (int i=0; i!= result.length; i++){
            s=i+1;
            while(s!= result.length){
                dil = result[s][i] / result[i][i];
                result[s][i] -= result[i][i] * dil;
                for (int j = i + 1; j != matrix[i].length; j++) {
                    result[s][j] -= result[i][j] * dil;
                }
                s++;
            }
        }
        while(k!=result.length){
            double diag = result[k][k];
            for(int j=0;j!=result[k].length;j++){
                result[k][j]/=diag;
            }
            k++;
        }
        return result;
    }
    public static double[] task12(double[][] triangle){
        int j=0;
        double[] x = new double[triangle.length];
        x[triangle.length-1]=triangle[triangle.length-1][triangle.length];
        for(int i= triangle.length-2;i>=0;i--){
            x[i]=triangle[i][triangle.length];
            j=i+1;
            while(j!=triangle.length){
                x[i]-=triangle[i][j]*x[j];
                j++;
            }
        }
        return x;
    }
    public static void task13(double[][] matrix,int choise){
        if(choise == 1) {
            System.out.println("Початкова матриця:");
            for (int i = 0; i != matrix.length; i++) {
                int j = 0;
                System.out.printf("|");
                while (j != matrix[i].length) {
                    if (matrix[i][j] % 1 != 0)
                        System.out.printf("%.3f\t", matrix[i][j]);
                    else System.out.printf("%5d\t", (int) matrix[i][j]);
                    j++;
                }
                System.out.printf("|");
                System.out.println(" ");
            }
        }else if(choise == 2) {
            System.out.println("Трикутна матриця:");
            for (int i = 0; i != matrix.length; i++) {
                int j = 0;
                System.out.printf("|");
                while (j != matrix[i].length) {
                    if (matrix[i][j] % 1 == 0 || (matrix[i][j] % 1 != 0 && Math.abs(matrix[i][j]) < 0.000001))
                        System.out.printf("%5d\t", (int) (matrix[i][j]));
                    else System.out.printf("%.3f\t", (matrix[i][j]));
                    j++;
                }
                System.out.printf("|");
                System.out.println(" ");
            }
        }
    }
    public static void task13(double[] x,int choise){
        if(choise==3) {
            System.out.println("Вектор результатів:");
            for (int i = 0; i != x.length; i++) {
                System.out.printf("|\t%.3f\t|", x[i]);
                System.out.println(" ");
            }
        }
    }
    public static int task2(int n){
        int sum=0;
        for(int i=1;i!=n+1;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum;
    }
}