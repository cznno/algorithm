import java.util.function.BiFunction;

/**
 * Created by cznno
 * Date: 18-2-7
 */
public class HammingMain {

    private static final String SEPARATOR = "============================================";
    private int bestMethod = 1;
    private int method = 1;
    private long bestMethodCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        System.out.println("String 1: " + a);
        System.out.println("String 2: " + b);
        System.out.println(SEPARATOR);

        HammingMain hammingMain = new HammingMain();
        hammingMain.doCalc(a, b, Hamming::method1);
        hammingMain.method++;
        hammingMain.doCalc(a, b, Hamming::method2);

        System.out.println("Best method is: " + hammingMain.bestMethod);
        System.out.println("Time cost is: " + hammingMain.bestMethodCost / 1000D + "us");
    }

    private void doCalc(String a, String b, BiFunction<String, String, Integer> hamming) {

        long startTime = System.nanoTime();
        int res = hamming.apply(a, b);
        long endTime = System.nanoTime();

        long totalTime = endTime - startTime;
        System.out.println(res);
        System.out.println(totalTime / 1000D + "us");
        System.out.println(SEPARATOR);

        if (totalTime < bestMethodCost) {
            bestMethod = method;
            bestMethodCost = totalTime;
        }
    }
}
