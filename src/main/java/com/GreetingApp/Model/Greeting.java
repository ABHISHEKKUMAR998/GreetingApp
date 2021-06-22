package com.GreetingApp.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.GreetingConfigure.GreetingConfigure;

@Entity
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)



	private long id;
	private String msg;
	
	public Greeting() {
	}

	public Greeting(GreetingConfigure greetingconfig) {
		this.msg = greetingconfig.msg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}
}
