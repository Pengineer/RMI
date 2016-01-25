package hust.rmi.service;

import hust.rmi.model.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 2，此为远程对象调用的接口，必须继承Remote类（这是Java API提供的类）
 * 
 * @author liangjian
 *
 */
public interface IPersonService extends Remote {

	public List<Person> getAllPerson() throws RemoteException;
	
}
