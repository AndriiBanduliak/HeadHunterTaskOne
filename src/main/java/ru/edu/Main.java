package ru.edu;

//import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n, m, s;
        int capacity;
        int[] a;
        int[] b;
        int counter = 0;

        Scanner in = new Scanner(System.in);

        /**
         * Принимаем размеры массивов и
         * максимальную сумму зарплат
         */

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
//        System.out.println("n=" + n + " m=" + m + " s=" + s);
//        System.out.println("capacity=" + capacity);


        /**
         * создаем массивы разной длинны
         */

        a = new int[n];
        b = new int[m];


        /**
         * заполняем массивы
         */

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
//        System.out.println("a= " + Arrays.toString(a) + " b=" + Arrays.toString(b));
//        System.out.println("n=" + n + " m=" + m);

        /**
         * мой алгоритм
         */

        for (int q = 0; q <= 1; q++) {

            int sumAllFirst = 0;
            int coutnallfirst = 0;

            int tmpCount = 0;
            int tmpSum = 0;

            for (int k = 0; k < a.length; ++k) {
//                System.out.println();
//                System.out.println(k + 1 + " проход");
                if ((sumAllFirst + a[k]) > s) {
//                    System.out.println();
//                    System.out.println("A: sumAllFirst = " + sumAllFirst);
//                    System.out.println("A: coutnallfirst = " + coutnallfirst);
//                    System.out.println("A: tmpCount = " + tmpCount);
//                    System.out.println("A: tmpSum = " + tmpSum);
//                    System.out.println("A: counter = " + counter);
//                    System.out.println("1 line---------------------");

                    if (tmpCount > counter) {
                        counter = tmpCount;
                    }
                    tmpSum = 0;
                    tmpCount = 0;
                    break;
                }

                tmpCount += 1 + coutnallfirst;
                coutnallfirst += 1;
                tmpSum += a[k] + sumAllFirst;
                sumAllFirst += a[k];
//                System.out.println();
//                System.out.println(sumAllFirst + " + ");
//                System.out.print(a[k]);

                for (int l = 0; l < b.length; ++l) {
                    if ((tmpSum + b[l]) > s || (sumAllFirst + b[l]) > s) {
                        if (tmpCount > counter) {
                            counter = tmpCount;
                        }
//                        System.out.println();
//                        System.out.println("B: sumAllFirst = " + sumAllFirst);
//                        System.out.println("B: coutnallfirst = " + coutnallfirst);
//                        System.out.println("B: tmpCount = " + tmpCount);
//                        System.out.println("B: tmpSum = " + tmpSum);
//                        System.out.println("B: counter = " + counter);
//                        System.out.println("2 line---------------------");
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
//                        System.out.print(" + " + b[l]);
//                        System.out.println();
//                        System.out.println("C: sumAllFirst = " + sumAllFirst);
//                        System.out.println("C: coutnallfirst = " + coutnallfirst);
//                        System.out.println("C: tmpCount = " + tmpCount);
//                        System.out.println("C: tmpSum = " + tmpSum);
//                        System.out.println("C: counter = " + counter);
//                        System.out.println("2 line---------------------");
                        tmpSum = 0;
                        tmpCount = 0;
                        break;
                    }
                    tmpCount += 1;
                    tmpSum += b[l];
//                    System.out.print(" + " + b[l]);

                }
            }

            int[] c = a;
            int[] d = b;
//            System.out.println("Массив с" + Arrays.toString(c));
//            System.out.println("Массив d" + Arrays.toString(d));
            a = d;
//            System.out.println("Массив a" + Arrays.toString(a));
            b = c;
//            System.out.println("Массив b" + Arrays.toString(b));
        }

//        System.out.print("Вывод: ");
        System.out.println(counter);
    }
}
