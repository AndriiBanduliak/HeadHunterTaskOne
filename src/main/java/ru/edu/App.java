package ru.edu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int n, m, s;
        int capacity;
        int[] a;
        int[] b;
        int counter = 0;

        Scanner in = new Scanner(System.in);

        String firstPile = in.next();
        n = Integer.parseInt(firstPile);
        capacity = n;
        String secondPile = in.next();
        m = Integer.parseInt(secondPile);
        if (capacity < m) {
            capacity = m;
        }
        String maxSum = in.next();
        s = Integer.parseInt(maxSum);

        a = new int[n];
        b = new int[m];


        for (int i = 0; i < capacity; i++) {
            String firstPileSalary = in.next();
            if (firstPileSalary.contains("-")) {
                System.out.print("");
            } else {
                a[i] = Integer.parseInt(firstPileSalary);
            }

            String secondPileSalary = in.next();
            if (secondPileSalary.contains("-")) {
                System.out.print("");
            } else {
                b[i] = Integer.parseInt(secondPileSalary);
            }
        }


        for (int q = 0; q <= 1; q++) {

            int sumAllFirst = 0;
            int countAllFirst = 0;

            int tmpCount = 0;
            int tmpSum = 0;

            for (int k = 0; k < a.length; ++k) {
                if ((sumAllFirst + a[k]) > s) {


                    if (tmpCount > counter) {
                        counter = tmpCount;
                    }
                    tmpSum = 0;
                    tmpCount = 0;
                    break;
                }
                tmpCount += 1 + countAllFirst;
                countAllFirst += 1;
                tmpSum += a[k] + sumAllFirst;
                sumAllFirst += a[k];

                for (int l = 0; l < b.length; ++l) {
                    if ((tmpSum + b[l]) > s || (sumAllFirst + b[l]) > s) {

                        if (tmpCount > counter) {
                            counter = tmpCount;
                        }
                        tmpSum = 0;
                        tmpCount = 0;
                        break;
                    }
                    if (l == b.length - 1) {
                        tmpCount += 1;
                        tmpSum += b[l];
                        if (tmpCount > counter) {
                            counter = tmpCount;
                        }
                        tmpSum = 0;
                        tmpCount = 0;
                        break;
                    }
                    tmpCount += 1;
                    tmpSum += b[l];

                }
            }

            int[] c = a;
            int[] d = b;
            a = d;
            b = c;
        }

        System.out.println(counter);
    }

}