package myjava.annotations;

public class Facade {

  @MyInject(value = MyInject.DayTime.MORNING)
  private Service service;

  String anotherField;

  @Override
  public String toString() {
    return "Facade [service=" + service + ", anotherField=" + anotherField + "]";
  }
}
