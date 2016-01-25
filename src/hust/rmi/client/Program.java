package hust.rmi.client;

import hust.rmi.model.Person;
import hust.rmi.service.IPersonService;

import java.rmi.Naming;
import java.util.List;

/**
 * 5，最后建立客户端进行测试，注意客户调用的RMI路径必须服务器配置一致
 * 
 * @author liangjian
 *
 */
public class Program {
	public static void main(String[] args){
		try{
			//调用远程服务对象，注意RMI路径与接口必须与服务器配置一致
			IPersonService personService = (IPersonService)Naming.lookup("rmi://127.0.0.1:6600/PersonService");
			List<Person> personList = personService.getAllPerson();
			for(Person person : personList){
				System.out.println("Name:" + person.getName() + " Age:" + person.getAge());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	  除了控制台的输出，可以再次看到本地服务的变化。（服务并没有终止）
	  C:\Users\liangjian>netstat -aon|findstr 6600
       TCP    0.0.0.0:6600           0.0.0.0:0              LISTENING       3100
       TCP    127.0.0.1:61594        127.0.0.1:6600         TIME_WAIT       0
       TCP    [::]:6600              [::]:0                 LISTENING       3100
	 */
}
