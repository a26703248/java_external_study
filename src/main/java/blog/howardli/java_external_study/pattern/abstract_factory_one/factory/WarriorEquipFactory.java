package blog.howardli.java_external_study.pattern.abstract_factory_one.factory;

import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Armor;
import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Clothes;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.LongSword;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Weapon;

public class WarriorEquipFactory implements EquipFactory{
    @Override
    public Weapon createWeapon() {
        LongSword longSword = new LongSword();
        longSword.setAtk(10);
        longSword.setRange(1);
        return longSword;
    }

    @Override
    public Clothes createClothes() {
        Armor armor = new Armor();
        armor.setDef(10);
        return armor;
    }
}
