package blog.howardli.java_external_study.pattern.abstract_factory_two.adventurer;

import blog.howardli.java_external_study.pattern.abstract_factory_one.clothes.Clothes;
import blog.howardli.java_external_study.pattern.abstract_factory_one.weapon.Weapon;

public abstract class Adventurer {

    protected Weapon weapon;

    protected Clothes clothes;

    public abstract void display();

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}
