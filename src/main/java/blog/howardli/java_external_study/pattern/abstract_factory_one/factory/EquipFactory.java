package blog.howardli.java_external_study.pattern.abstract_factory_one.factory;

import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Clothes;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Weapon;

public interface EquipFactory {

    Weapon createWeapon();

    Clothes createClothes();

}
