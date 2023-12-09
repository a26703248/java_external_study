package blog.howardli.java_external_study.pattern.visitor;



public interface CarElementVisitor {

    public void visit(Wheel wheel);

    public void visit(Engine engine);

    public void visit(Body body);

    public void visit(Car car);

}
