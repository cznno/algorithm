import java.util.function.BiFunction;

/**
 * Created by cznno
 * Date: 18-2-7
 */
public class Main {

    private static final String SEPARATOR = "============================================";

    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        System.out.println("String 1: " + a);
        System.out.println("String 2: " + b);
        System.out.println(SEPARATOR);

        doCalc(a, b, Hamming::method1);
        doCalc(a, b, Hamming::method2);
    }

    private static void doCalc(String a, String b, BiFunction<String, String, Integer> hamming) {
        long startTime = System.nanoTime();
        int res = hamming.apply(a, b);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(res);
        System.out.println(totalTime / 1000D + "us");
        System.out.println(SEPARATOR);
    }
}
