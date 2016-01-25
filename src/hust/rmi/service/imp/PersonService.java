package hust.rmi.service.imp;

import hust.rmi.model.Person;
import hust.rmi.service.IPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * 3，实现远程接口，注意此为远程对象实现类，需要继承UnicastRemoteObject
 * 
 * @author liangjian
 *
 */
public class PersonService extends UnicastRemoteObject implements IPersonService {

	private static final long serialVersionUID = -5657719415378778587L;

	public PersonService() throws RemoteException {
		super();
	}

	@Override
	public List<Person> getAllPerson() {
		System.out.println("Get Person Start!");
		List<Person> personList=new LinkedList<Person>();

		Person person1=new Person();
		person1.setAge(22);
		person1.setName("Jack");
		personList.add(person1);

		Person person2=new Person();
		person2.setAge(20);
		person2.setName("Rose");
		personList.add(person2);

		return personList;
	}

}
