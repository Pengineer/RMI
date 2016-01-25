package hust.rmi.server;

import hust.rmi.service.IPersonService;
import hust.rmi.service.imp.PersonService;

import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 4，建立服务器端，在服务器端注册RMI通讯端口与通讯路径，然后通讯javac命令编译文件，通过java -server 命令注册服务。
 * 
 * @author liangjian
 *
 */
public class ServerProgram {
	public static Remote remote = null;
	
	public static void main(String[] args) {
		try {
			IPersonService personService = new PersonService();
			//注册通讯端口
			remote = LocateRegistry.createRegistry(6600);
			//注册通讯路径
//			Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);    // 客户端和服务端均在本地
			Naming.rebind("rmi://192.168.88.6:6600/PersonService", personService); // 客户端在192.168.88.176上（将model和service接口两个package打成jar包放到客户端，注意不需要service的实现）
			System.out.println("Service start and will stop after 20s.");
			//停止服务的线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(20000);
						boolean isStop = UnicastRemoteObject.unexportObject(remote, true);
						System.out.println("服务停止：" + isStop);
						System.exit(0);
					} catch (NoSuchObjectException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "StopThread").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	   启动该服务后，可以在DOS下观察结果：
	  C:\Users\liangjian>netstat -aon|findstr 6600
    TCP    0.0.0.0:6600           0.0.0.0:0              LISTENING       3100
    TCP    127.0.0.1:6600         127.0.0.1:61594        ESTABLISHED     3100
    TCP    127.0.0.1:61594        127.0.0.1:6600         ESTABLISHED     3100
    TCP    [::]:6600              [::]:0                 LISTENING       3100
	 */
	
}
