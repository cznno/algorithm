package practice.sort;

import java.util.function.UnaryOperator;

/**
 * 希尔排序,基于插入排序
 * 使数组中任意间隔为h的元素都是有序的
 * 对于每个h,用插入排序将每个元素交换到比它大的元素之前
 * Created by cznno
 * Date: 18-3-9
 */
public class Shell extends BaseSort implements UnaryOperator<Comparable[]> {

    private static <T> Comparable[] sort(Comparable<T>[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], (T) a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
        return a;
    }

    public static void main(String[] args) {
        doSort(Shell::sort);
    }

    @Override
    public Comparable[] apply(Comparable[] a) {
        return sort(a);
    }
}
