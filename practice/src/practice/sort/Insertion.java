package practice.sort;

import java.util.function.UnaryOperator;

/**
 * 插入排序,对于0到N-1之间的每一个元素,
 * 将a[i]与a[0]到a[i-1]中比他小的元素依次有序交换,
 * 索引i从左向右移动,其左侧元素始终有序
 * Created by cznno
 * Date: 18-3-9
 */
class Insertion extends BaseSort implements UnaryOperator<Comparable[]> {

    private static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //倒序比较
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
        return a;
    }

    @Override
    public Comparable[] apply(Comparable[] a) {
        return sort(a);
    }

    public static void main(String[] args) {
        doSort(Insertion::sort);
    }
}
