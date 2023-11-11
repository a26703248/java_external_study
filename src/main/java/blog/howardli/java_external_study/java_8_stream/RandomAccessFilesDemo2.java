package blog.howardli.java_external_study.java_8_stream;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFilesDemo2 {
    public static void main(String[] args) {
        try (RandomAccessFile raf1 = new RandomAccessFile(new File("testString.txt"), "rw");) {
            StringBuilder builder = new StringBuilder((int) new File("testString.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }
            raf1.seek(3); // 指定插入位置
            raf1.write("xyz".getBytes());

            raf1.write(builder.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
