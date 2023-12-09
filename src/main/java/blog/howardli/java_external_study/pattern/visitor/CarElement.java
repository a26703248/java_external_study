package blog.howardli.java_external_study.pattern.visitor;

public interface CarElement {

    void accept(CarElementVisitor visitor);

}
