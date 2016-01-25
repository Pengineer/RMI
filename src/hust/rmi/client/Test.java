package hust.rmi.client;

import hust.rmi.service.IPersonService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 线程安全测试
 * 
 * @author liangjian
 *
 */
public class Test {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
	
	static class MyThread extends Thread {

		@Override
		public void run() {
			try {
				IPersonService personService = (IPersonService)Naming.lookup("rmi://127.0.0.1:6600/PersonService");
				boolean isSuccess = personService.addPerson("john snow", 24);
				System.out.println(Thread.currentThread().getName() + " 当前元素个数：" + personService.getAllPerson().size() + " 添加成功：" + isSuccess);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
