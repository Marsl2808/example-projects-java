package myjava.annotations;

public class Facade {

  @MyInject(value = MyInject.DayTime.MORNING)
  Service service;

  String anotherField;
}
