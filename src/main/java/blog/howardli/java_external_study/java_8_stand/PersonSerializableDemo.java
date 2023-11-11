package blog.howardli.java_external_study.java_8_stand;

import java.io.*;

/*
 * 物件要序列化物件必須要滿足,才可執行序列化
 * 1. 需 implements Serializable, Deserialize 標示介面
 * 2. 需要提供一個版本定義靜態常數
 * 3. 必須注意類別內部所有屬性都可序列化(implements Serializable, Deserialize 介面)
 *
 * 注意點:
 * transient(暫時性的部會序列化), static(靜態修飾符方法屬性不歸物件管理) 不可在序列化物件內使用(不會報錯)
 */
public class PersonSerializableDemo implements Serializable {

    public static void main(String[] args) {
        // 物件序列化
        Person p1 = new Person("小明", 25);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            oos.writeObject(p1); // 寫入
            oos.flush(); // 更新
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 物件反序列化
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Object obj = ois.readObject();
            Person p2 = (Person) obj;
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private Integer age;
    private static final long serialVersionUID = 1L;

    public Person() {
    }
    public Person(String name, Integer age) {
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
        return "Person [age=" + age + ", name=" + name + "]";
    }

}
