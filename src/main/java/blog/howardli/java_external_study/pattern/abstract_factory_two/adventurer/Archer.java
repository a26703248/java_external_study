package blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer;

public class Archer extends Adventurer{

    @Override
    public void display() {
        System.out.printf("I'm a archer%n");
        weapon.display();
        System.out.println();
        clothes.display();
        System.out.println();
    }
}
