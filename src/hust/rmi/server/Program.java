package hust.rmi.server;

import hust.rmi.service.IPersonService;
import hust.rmi.service.imp.PersonService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 4，建立服务器端，在服务器端注册RMI通讯端口与通讯路径，然后通讯javac命令编译文件，通过java -server 命令注册服务。
 * 
 * @author liangjian
 *
 */
public class Program {
	
	public static void main(String[] args) {
		try {
			IPersonService personService = new PersonService();
			//注册通讯端口
			LocateRegistry.createRegistry(6600);
			//注册通讯路径
			Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
			System.out.println("Service Start!");
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
