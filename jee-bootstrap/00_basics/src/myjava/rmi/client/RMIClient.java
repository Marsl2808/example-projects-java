package myjava.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import myjava.rmi.Hello;

public class RMIClient {

  public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
    Hello hello = (Hello) Naming.lookup("rmi://localhost:1099/hello");
    System.out.println("Hello: " + hello.getClass().getName());
    System.out.println(hello.hello("duke"));
  }
}
