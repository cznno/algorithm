package practice;

import java.io.*;

/**
 * 生成随机数到文件
 * Created by cznno
 * Date: 18-3-8
 */
class Random {
    public static void main(String[] args) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./practice/src/practice/sort/input"))) {
            int i = 0;
            do {
                Integer id = new java.util.Random().nextInt(255);
                out.write(id.toString() + " ");
            } while (i++ < 100);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
