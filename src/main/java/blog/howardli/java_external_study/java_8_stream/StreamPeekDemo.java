package blog.howardli.java_external_study.java_8_stream;

import java.util.stream.IntStream;

public class StreamPeekDemo {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .peek(System.out::println)
                .map(n -> n * n)
                .peek(System.out::println)
                .filter(n -> n % 5 == 0)
                .peek(System.out::println)
                .sum();
    }
}
