package blog.howardli.java_external_study.pattern.abstract_factory_two.training_camp;

import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.EquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.WarriorEquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer.Adventurer;
import blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer.Warrior;

public class WarriorTrainingCamp implements TrainingCamp{

    private static EquipFactory factory = new WarriorEquipFactory();

    @Override
    public Adventurer trainAdventurer() {
        System.out.println("Warrior training start");
        Warrior warrior = new Warrior();
        warrior.setWeapon(factory.createWeapon());
        warrior.setClothes(factory.createClothes());
        return warrior;
    }
}
