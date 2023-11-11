package blog.howardli.java_external_study.java_8_stream;

import java.io.File;
import java.io.RandomAccessFile;

/*
 * 任意存取流
 * 1. 既可以當輸出流或輸入流
 * 2. 若檔案不存在將會自動建立檔案,但檔案已存在且檔案已有內容將會從頭覆蓋
 */
public class RandomAccessFilesDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf1 = new RandomAccessFile(new File("object.txt"), "r");
             RandomAccessFile raf2 = new RandomAccessFile(new File("object1.txt"), "rw");) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
