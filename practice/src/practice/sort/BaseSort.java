package practice.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
 * Created by cznno
 * Date: 18-3-8
 */
abstract class BaseSort {

    private static Integer[] integers;

    static {
        try {
            FileReader reader = new FileReader("./practice/src/practice/sort/input");
            BufferedReader br = new BufferedReader(reader);
            String strLine;
            String[] strings = new String[0];
            while ((strLine = br.readLine()) != null) {
                strings = strLine.split(" ");
            }
            br.close();
            reader.close();
            integers = new Integer[strings.length];
            for (int i = 0; i < strings.length; i++)
                integers[i] = Integer.parseInt(strings[i]);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T> void show(Comparable<T>[] a) {
        for (Comparable<T> anA : a) System.out.println(anA + " ");
        System.out.println();
    }

    private static <T> boolean isSorted(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], (T) a[i - 1])) return false;
        }
        return true;
    }

    static <T> boolean less(Comparable<T> v, T w) {
        return v.compareTo(w) < 0;
    }

    static void doSort(UnaryOperator<Comparable[]> function) {
        System.out.println("unsorted:");
//        show(BaseSort.integers);
        System.out.println("sorted:");
        long start = System.nanoTime();
        Comparable[] res = function.apply(BaseSort.integers);
        System.out.println("used:" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms");
        assert BaseSort.isSorted(res);
        show(res);
    }
}
