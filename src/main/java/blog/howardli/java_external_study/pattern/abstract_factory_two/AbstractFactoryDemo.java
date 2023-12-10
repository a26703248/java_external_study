package blog.howardli.java_external_study.pattern.abstract_factory_two;

import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Clothes;
import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.ArcherEquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.EquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_one.factory.WarriorEquipFactory;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Weapon;
import blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer.Adventurer;
import blog.howardli.java_external_study.pattern.abstract_factory_two.training_camp.ArcherTrainingCamp;
import blog.howardli.java_external_study.pattern.abstract_factory_two.training_camp.TrainingCamp;
import blog.howardli.java_external_study.pattern.abstract_factory_two.training_camp.WarriorTrainingCamp;

public class AbstractFactoryDemo {

    private static EquipFactory equipFactory;

    public static void main(String[] args) {
        System.out.println("==========abstract factory 1==========");

        // 幫弓箭手生產裝備
        equipFactory = new ArcherEquipFactory();
        Clothes archerLeather = equipFactory.createClothes();
        Weapon archerBow = equipFactory.createWeapon();

        // 皮甲的防禦應該是5，弓的攻擊為10，範圍為10
        System.out.println("archerLeather.getDef() = " + archerLeather.getDef());
        System.out.println("archerBow.getAtk() = " + archerBow.getAtk());
        System.out.println("archerBow.getRange() = " + archerBow.getRange());

        // 幫鬥士生產裝備
        equipFactory = new WarriorEquipFactory();
        Clothes armor = equipFactory.createClothes();
        Weapon longSword = equipFactory.createWeapon();

        // 盔甲的防禦應該是10，弓的攻擊為10，範圍為1
        System.out.println("armor.getDef() = " + armor.getDef());
        System.out.println("longSword.getAtk() = " + longSword.getAtk());
        System.out.println("longSword.getRange() = " + longSword.getRange());

        System.out.println("==========abstract factory 2==========");
        // 弓箭手訓練營
        TrainingCamp camp = new ArcherTrainingCamp();
        // 訓練弓箭手
        Adventurer archer = camp.trainAdventurer();

        // 鬥士訓練營
        camp = new WarriorTrainingCamp();
        // 訓練鬥士
        Adventurer warrior = camp.trainAdventurer();

        archer.display();
        warrior.display();
    }
}
