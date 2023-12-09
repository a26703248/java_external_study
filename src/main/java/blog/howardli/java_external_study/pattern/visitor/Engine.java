package blog.howardli.java_external_study.pattern.visitor;

public class Engine implements CarElement {

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
