package hust.rmi.client;

import hust.rmi.model.Person;
import hust.rmi.service.IPersonService;

import java.rmi.Naming;
import java.util.List;

/**
 * 5，最后建立客户端进行测试，注意客户调用的RMI路径必须服务器配置一致（此处是本地客户端测试，本地IP：192.168.88.6）
 * 
 * @author liangjian
 *
 */
public class ClientProgram {
	public static void main(String[] args){
		try{
			//调用远程服务对象，注意RMI路径与接口必须与服务器配置一致
			IPersonService personService = (IPersonService)Naming.lookup("rmi://127.0.0.1:6600/PersonService");
			final List<Person> personList = personService.getAllPerson();
			System.out.println("当前元素个数：" + personList.size() + " 如下：");
			for(Person person : personList){
				System.out.println("Name:" + person.getName() + " Age:" + person.getAge());
			}
			boolean isSuccess = personService.addPerson("john snow", 24);
//			System.out.println("当前元素个数：" + personList.size() + " 添加成功：" + isSuccess); // error code ：personList已经被本地化了，需要重新获取最新的list
			System.out.println("当前元素个数：" + personService.getAllPerson().size() + " 添加成功：" + isSuccess);
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
