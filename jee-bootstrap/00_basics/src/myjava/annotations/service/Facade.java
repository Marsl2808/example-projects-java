package myjava.annotations.service;

public class Facade {

  @MyInject(value = MyInject.DayTime.MORNING)
  private Service service;

  String anotherField;

  public void invokeService(){
    service.serve();
  }

  @Override
  public String toString() {
    return "Facade [service=" + service + ", anotherField=" + anotherField + "]";
  }
}
