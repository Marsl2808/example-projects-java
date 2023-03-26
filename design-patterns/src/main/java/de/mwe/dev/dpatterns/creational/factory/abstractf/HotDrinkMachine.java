package de.mwe.dev.dpatterns.creational.factory.abstractf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.javatuples.Pair;
import org.reflections.Reflections;

public class HotDrinkMachine {

  List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

  final String MY_PACKAGE_PATH = "de.mwe.dev.dpatterns.creational.factory.abstractf";

  public HotDrinkMachine() throws Exception {
    Set<Class<? extends HotDrinkFactory>> factorytypes = new Reflections(MY_PACKAGE_PATH).getSubTypesOf(HotDrinkFactory.class);

    for (Class<? extends HotDrinkFactory> factoryType : factorytypes) {
      namedFactories.add(new Pair<String, HotDrinkFactory>(
          factoryType.getSimpleName().replace("Factory", ""), factoryType.getDeclaredConstructor().newInstance()));
    }
  }

  public HotDrink makeDrink() throws Exception{

    System.out.println("Available drinks:");
    for(int i = 0; i< namedFactories.size(); i++){
      Pair<String, HotDrinkFactory> item = namedFactories.get(i);
      System.out.println("" + i + ": " + item.getValue0());
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      String s;
      int i, amount;
      if((s = br.readLine()) != null 
        && (i = Integer.parseInt(s)) >= 0
        && i < namedFactories.size()){
          System.out.println("Specify amount: ");
          s = br.readLine();
          if(s != null && (amount = Integer.parseInt(s)) > 0){
            return namedFactories.get(i).getValue1().prepare(amount);
          }
      }
      System.out.println("Incorrect input, try again.");
    }
  }

  public static void main(String[] args) {
    try {
      HotDrinkMachine hotDrinkMachine = new HotDrinkMachine();
      HotDrink drink = hotDrinkMachine.makeDrink();
      drink.consume();
    } catch (Exception e) {
      System.out.println("Exception occured during object creation: " + e.getClass() + "\n"+ e.getMessage());
    }
  }
}
