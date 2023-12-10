package blog.howardli.java_external_study.pattern.abstract_factory_one.weapon;

public abstract class Weapon {
    protected int atk;

    protected int range;

    public void display() {
        System.out.printf("name: %s,attack: %d,range: %d\n", getClass().getSimpleName(), atk, range);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
