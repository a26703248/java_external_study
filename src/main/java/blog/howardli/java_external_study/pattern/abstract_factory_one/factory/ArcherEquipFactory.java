package blog.howardli.java_external_study.pattern.abstract_factory_one.factory;

import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Clothes;
import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Leather;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Bow;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Weapon;

public class ArcherEquipFactory implements EquipFactory{
    @Override
    public Weapon createWeapon() {
        Bow bow = new Bow();
        bow.setAtk(10);
        bow.setRange(10);
        return bow;
    }

    @Override
    public Clothes createClothes() {
        Leather leather = new Leather();
        leather.setDef(5);
        return leather;
    }
}
