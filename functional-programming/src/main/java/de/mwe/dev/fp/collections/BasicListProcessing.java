package de.mwe.dev.fp.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasicListProcessing {

  private List<String> names = Arrays.asList("Brian", "Maria", "Chris", "Norbertus", "Nuno");

  public void printNames() {
    // 1) print names by anonymous inner class
    // foreach() is part of iterator-interface
    names.forEach(new Consumer<String>() {
      public void accept(String name) {
        System.out.print(name + " ");
      }
    });
    System.out.println("\n---------------------(1)");
    // 2) print by lambda
    names.forEach((final String name) -> System.out.print(name + " "));
    System.out.println();
    names.forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(2)");
    // 3) print by Method reference
    names.forEach(System.out::print);
    System.out.println("\n---------------------(3)");
  }

  private void convertToUpperCase() {
    // map returns a new object stream, foreach needs a consumer
    names.stream()
        .map(name -> name.toUpperCase())
        .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(4)");
  }

  private void printWordsWithStartingChar() {
    // reusing lambda expression by Predicate
    final Predicate<String> startsWithN = name -> name.startsWith("N");
    names.stream()
        .filter(startsWithN)
        .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(5)");

    // avoid duplicated code by lexical scoping
    final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
      Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
      return checkStarts;
    };
    names.stream()
        .filter(startsWithN)
        .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(6)");
    names.stream()
        .filter(startsWithLetter.apply("B"))
        .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(7)");

    // can also be written more concise
    final Function<String, Predicate<String>> startsWithLetterConcise = letter -> name -> name.startsWith(letter);
    names.stream()
        .filter(startsWithLetterConcise.apply("M"))
        .forEach(name -> System.out.print(name + " "));
    System.out.println("\n---------------------(8)");
  }

  private void pickName() {
    String startingLetter = "N";
    final Optional<String> foundName = names.stream()
        .filter(name -> name.startsWith("N"))
        .findFirst();
    System.out.println(String.format("A name starting with %s: %s",
        startingLetter, foundName.orElse("No name found")));
    System.out.println("\n---------------------(9)");
  }

  private void reduceCollectionToSingleVal() {
    // map-reduce approach -> sum is a reducer
    System.out.println("Total number of characters in all names: " +
        names.stream()
            .mapToInt(name -> name.length())
            .sum());
    /**
     * As the reduce() method iterated through the collection, it called the lambda
     * expression first, with the first two elements in the list.
     * The result from the lambda expression is used for the subsequent call. In the
     * second call name1 is bound to the result from the previous
     * call to the lambda expression, and name2 is bound to the third element in the
     * collection. The calls to the lambda expression continue for
     * the rest of the elements in the collection. The result from the final call is
     * returned as the result of the reduce() method call.
     */
    final Optional<String> aLongName = names.stream()
        .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
    aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
    // base/default value can also be set s.t. no Optional is returned
    String aLongName2 = names.stream().reduce("AVeryLongDefaultNameToShow",
        (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
    System.out.println(aLongName2);

  }

  public static void main(String[] args) {
    BasicListProcessing blp = new BasicListProcessing();
    blp.printNames();
    blp.convertToUpperCase();
    blp.printWordsWithStartingChar();
    blp.pickName();
    blp.reduceCollectionToSingleVal();
  }
}
