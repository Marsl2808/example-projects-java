package de.mwe.dev.fp.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BasicListProcessing {

  public void printNames() {
    List<String> names = Arrays.asList("Brian", "Maria", "Chris");
    // 1) print names by anonymous inner class
    // foreach() is part of iterator-interface
    names.forEach(new Consumer<String>() {
      public void accept(String name) {System.out.print(name + " ");}
    });
    System.out.println("\n---------------------");
    // 2) print by lambda
    names.forEach((final String name) -> System.out.print(name + " "));
    names.forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------");
    // 3) print by Method reference
    names.forEach(System.out::print);
    System.out.println("\n---------------------");
  }
  private void convertToUpperCase() {
    List<String> names = Arrays.asList("Brian", "Maria", "Chris");
    names.stream()
         .map(name -> name.toUpperCase())
         .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------");
  }

  public static void main(String[] args) {
    BasicListProcessing blp = new BasicListProcessing();
    blp.printNames();
    blp.convertToUpperCase();
  }

}
