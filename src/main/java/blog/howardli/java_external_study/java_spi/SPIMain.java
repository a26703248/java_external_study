package blog.howardli.java_external_study.java_spi;

import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader.load(ServiceInterface.class)
                .forEach(ServiceInterface::execute);
    }
}
