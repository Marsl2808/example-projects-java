package myjava.annotations;

import java.lang.reflect.Field;

public class MyOwnAnnotation {

  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> clazz = Class.forName("annotations.Facade");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      MyInject myInject = field.getAnnotation(MyInject.class);
      if (myInject != null) {
        System.out.printf("Field %s is annotated with %s", field, myInject);
      } else {
        System.out.printf("Field %s is not annotated", field);
      }
    }
  }
}
