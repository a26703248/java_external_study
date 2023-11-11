package blog.howardli.java_external_study.java_8_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCheckSortedDemo {
    public static void main(String[] args) {
        List<String> content = Arrays.asList("this", "is", "a", "Java", "Code");
        content = content.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        content.stream().reduce((prev, curr) -> {
            if(!(prev.length() <= curr.length())){
                System.out.println("未排序");
            }
            return curr;
        });
        content.stream().forEach(System.out::println);
    }
}
