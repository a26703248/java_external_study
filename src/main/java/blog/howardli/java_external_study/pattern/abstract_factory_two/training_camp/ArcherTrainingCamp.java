package blog.howardli.java_external_study.pattern.abstract_factory_two.training_camp;

import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.ArcherEquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.EquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer.Adventurer;
import blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer.Archer;

public class ArcherTrainingCamp implements TrainingCamp{

    private static EquipFactory factory = new ArcherEquipFactory();

    @Override
    public Adventurer trainAdventurer() {
        System.out.println("Archer training start");
        Archer archer = new Archer();
        archer.setWeapon(factory.createWeapon());
        archer.setClothes(factory.createClothes());
        return archer;
    }
}
