package myjava.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import myjava.rmi.Hello;

/**
 * Serverside implementation of Hello (not known by client)
 */
public class HelloServant extends UnicastRemoteObject implements Hello{

  protected HelloServant() throws RemoteException {
    // ctor of superclass throws RemoteException
    super();
  }

  @Override
  public String hello(String msg) throws RemoteException {
    return "Hello client: " + msg;
  }
}
