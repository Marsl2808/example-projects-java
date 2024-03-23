package myjava.annotations;

import java.lang.reflect.Field;

import myjava.annotations.decorator.Decorator;
import myjava.annotations.service.Facade;
import myjava.annotations.service.MyInject;

public class MyOwnAnnotation {

  static final String FQM_FACADE = "myjava.annotations.service.Facade";

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<?> clazz = Class.forName(FQM_FACADE);
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      MyInject myInject = field.getAnnotation(MyInject.class);
      if (myInject != null) {
        System.out.printf("Field %s is annotated with %s", field, myInject);
        Object facade = clazz.newInstance();
        Class<?> serviceType = field.getType();
        // without interface, serviceType culd be instantiated directly
        // Object service = serviceType.newInstance();

        // convention over cfg. -> Impl Postfix
        String className = serviceType.getSimpleName() + "Impl";
        String packageName = serviceType.getPackage().getName();
        String fullName = packageName + "." + className;
        // create instance
        Object service = Class.forName(fullName).newInstance();

        // make private fields available for reflection
        field.setAccessible(true);
        // inject Proxy-Object (alternatively service can directly injected)
        field.set(facade, Decorator.decorate(service));

        // try decoration
        Facade typedFacade = (Facade) facade;
        typedFacade.invokeService();

        System.out.println("\nFacade: " + facade);
      } else {
        System.out.printf("Field %s is not annotated", field);
      }
    }
  }
}
