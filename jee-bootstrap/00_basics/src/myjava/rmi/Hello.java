package myjava.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Hello interface is known by server AND client -> contract.
 * The implementation is of course only known by the server.
 */
public interface Hello extends Remote{
  
  public String hello(String msg) throws RemoteException;
}
