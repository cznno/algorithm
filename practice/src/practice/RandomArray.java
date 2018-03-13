package practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 生成随机数到文件
 * Created by cznno
 * Date: 18-3-8
 */
class RandomArray {

    private static final String PATH = "./practice/src/practice/sort/input";

    public static void main(String[] args) {
        newRandom(1, 100000000, 10000000);
    }

    private static void oldRandom() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH))) {
            int i = 0;
            do {
                Integer id = new Random().nextInt(255);
                out.write(id.toString() + " ");
            } while (++i < 100);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void newRandom(int origin, int bound, int size) {
        long start = System.nanoTime();
        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(Paths.get(PATH)))) {
            new Random().ints(origin, bound).limit(size)
                    .mapToObj(value -> value + " ")
                    .forEach(pw::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("used:" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms");
    }
}
