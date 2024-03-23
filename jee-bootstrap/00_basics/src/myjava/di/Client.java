package myjava.di;

public class Client {

  public static void main(String[] args) {
    Configuration config = (Configuration) ObjectFactory.getInstance().create();
  }
}
