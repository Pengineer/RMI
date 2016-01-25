package hust.rmi.model;

import java.io.Serializable;

/**
 * 1，首先为服务建立一个Model层，注意因为此对象需要现实远程传输，所以必须继承Serializable.
 * 
 * @author liangjian
 *
 */

public class Person implements Serializable {

	private static final long serialVersionUID = 3741070782149008070L;
	
	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
