package blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer;

public class Warrior extends Adventurer{
    @Override
    public void display() {
        System.out.println("I'm a warrior");
        weapon.display();
        System.out.println();
        clothes.display();
        System.out.println();
    }
}
