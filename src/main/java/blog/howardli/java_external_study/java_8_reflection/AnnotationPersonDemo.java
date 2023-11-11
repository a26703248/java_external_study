package blog.howardli.java_external_study.java_8_reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationPersonDemo extends CreatureDemo<String> implements MyInterface, Comparable<String> {
    private String name;
    public Integer age;
    int id;

    public AnnotationPersonDemo() {
    }
    @MyAnnotation("abc")
    private AnnotationPersonDemo(String name) {
        this.name = name;
    }
    public AnnotationPersonDemo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @MyAnnotation
    public void show() throws NullPointerException {
        System.out.println("name:" + name + ", " + "age: " + age);
    }

    private String sayHi(String target) throws IllegalArgumentException, IllegalAccessException {
        return target + " Hi!";
    }
    @Override
    public void info() {
        System.out.println("我是人");
    }
    @Override
    public int compareTo(String arg0) {
        return 0;
    }

    private static void display() {
        System.out.println("display");
    }
}

@Retention(RetentionPolicy.SOURCE)
@interface MyAnn{
    String value() default "Nothing";
}