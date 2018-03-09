package practice.sort;

import java.util.function.UnaryOperator;

/**
 * 首先在未排序序列中找到最小（大）元素，
 * 把它和序列的第一个(最后一个)元素交换,
 * 然后在剩下的元素中找到最小元素, 和第二个元素交换, 以此类推
 * <p>
 * 选择最小值需要扫描N个元素（比较n-1次）， 然后将其交换到第一个位置。
 * 找到下一个最低元素需要扫描剩余的n-1个元素，依此类推。
 * 复杂度O(n^2)
 * Created by cznno
 * Date: 18-3-8
 */
class Selection extends BaseSort implements UnaryOperator<Comparable[]> {

    public static void main(String[] args) {
        doSort(Selection::sort);
    }

    private static <T> Comparable[] sort(Comparable<T>[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], (T) a[min])) min = j;
            exch(a, i, min);
        }
        return a;
    }

    @Override
    public Comparable[] apply(Comparable[] a) {
        return sort(a);
    }
}
