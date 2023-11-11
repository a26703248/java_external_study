package blog.howardli.java_external_study.java_8_reflection;

import java.io.Serializable;

public class CreatureDemo<T> implements Serializable {
    private Character gender;
    public Double weight;

    private void breath() {
        System.out.println("呼吸");
    }

    public void eat() {
        System.out.println("吃東西");
    }
}
