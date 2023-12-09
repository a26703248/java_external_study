package blog.howardli.java_external_study.pattern.visitor;

public class VisitorDemo {
    public static void main(String[] args) {
        CarElement car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
