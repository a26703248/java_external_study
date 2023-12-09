package blog.howardli.java_external_study.pattern.visitor;

public class Wheel implements CarElement {

    private String name;

    public Wheel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }

}
