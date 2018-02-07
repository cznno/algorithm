import java.util.stream.IntStream;

/**
 * Created by cznno
 * Date: 18-2-7
 */
class Hamming {

    static int method1(String a, String b) {


        int len = a.length();
        int dis = -1;
        if (a.length() == b.length()) {
            dis = 0;
            for (int i = 0; i < len; i++) {
                if ((a.charAt(i) - b.charAt(i) != 0))
                    dis++;
            }
        }
        return dis;
    }

    static int method2(String a, String b) {
        int len = a.length();
        return Math.toIntExact(IntStream.range(0, len)
                .filter(i -> (a.charAt(i) - b.charAt(i) != 0))
                .count());
    }
}
