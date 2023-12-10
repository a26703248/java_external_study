package blog.howardli.java_external_study.pattern.abstract_factory_one.clothes;

public abstract class Clothes {
    protected int def;

    public void display() {
        System.out.printf("name: %s,defend: %d\n", getClass().getSimpleName(), def);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
