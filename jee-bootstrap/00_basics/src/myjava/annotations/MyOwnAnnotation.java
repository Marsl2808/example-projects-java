package myjava.annotations;

import java.lang.reflect.Field;

public class MyOwnAnnotation {

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<?> clazz = Class.forName("myjava.annotations.Facade");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      MyInject myInject = field.getAnnotation(MyInject.class);
      if (myInject != null) {
        System.out.printf("Field %s is annotated with %s", field, myInject);
        Object facade = clazz.newInstance();
        Class<?> serviceType = field.getType();
        Object service = serviceType.newInstance();
        field.setAccessible(true);
        field.set(facade, service);
        System.out.println("\nFacade: " + facade);
      } else {
        System.out.printf("Field %s is not annotated", field);
      }
    }
  }
}
