package hust.rmi.service;

import hust.rmi.model.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 2，此为远程对象调用的接口，必须继承Remote类（这是Java API提供的类）
 * 
 * Java API介绍：
 * Remote接口用于标识其方法可以被非本地虚拟机所调用。任何远程对象都必须直接或间接实现此接口。只有在“远程接口”（扩展 java.rmi.Remote 的接口）
 * 中指定的这些方法才可远程使用。 
 * 实现类可以实现任意数量的远程接口，并且可以扩展其他远程实现类。RMI提供了一些有用类给远程对象进行扩展，这些类便于远程对象创建。这些类是
 * java.rmi.server.UnicastRemoteObject 和 java.rmi.activation.Activatable。
 * 
 * @author liangjian
 *
 */
public interface IPersonService extends Remote {

	public List<Person> getAllPerson() throws RemoteException;
	
	public boolean addPerson(String name, int age) throws RemoteException;
	
}
