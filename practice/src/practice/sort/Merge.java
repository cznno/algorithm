package practice.sort;

import java.util.function.UnaryOperator;

/**
 * Created by cznno
 * Date: 18-3-13
 */
public class Merge extends BaseSort implements UnaryOperator<Comparable[]> {

    private static Comparable[] aux;

    public static void main(String[] args) {
        doSort(Merge::sort);
    }

    private static <T> Comparable[] sort(Comparable<T>[] a) {
        aux = new Comparable[a.length];
        return sort(a, 0, a.length - 1);
    }

    private static <T> Comparable[] sort(Comparable<T>[] a, int lo, int hi) {
        if (hi <= lo)
            return a;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        return merge(a, lo, mid, hi);
    }

    @SuppressWarnings("unchecked")
    private static <T> Comparable<T>[] merge(Comparable<T>[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
        return a;
    }

    @Override
    public Comparable[] apply(Comparable[] a) {
        return sort(a);
    }
}
