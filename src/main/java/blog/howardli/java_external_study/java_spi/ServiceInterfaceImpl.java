package blog.howardli.java_external_study.java_spi;

public class ServiceInterfaceImpl implements ServiceInterface{

    @Override
    public void execute() {
        System.out.println("ServiceInterfaceImpl.execute()");
    }
}
