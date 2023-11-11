package blog.howardli.java_external_study.java_8_nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NIO2Demo {
    public static void main(String[] args) {
        NIO2Demo nio2 = new NIO2Demo();
    }

    public void demo1() {
        // 讀取資料夾內所有檔案路徑
        try (Stream<Path> list = Files.list(Paths.get("src/main/data/resources"));) {
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demo2() {
        // 讀檔
        try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/data/demo1.txt"))) {
            lines.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
