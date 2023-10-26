package de.mwe.dev.dpatterns.creational.builder.person;

public class PersonBuilder<T extends PersonBuilder<T>> {

  protected Person p = new Person();

  public PersonBuilder(){
  }

  public T name(String name){
    p.name = name;
    return self();
  }

  public T self(){
    return (T) this;
  }

  public Person build(){
    return p;
  }
}
