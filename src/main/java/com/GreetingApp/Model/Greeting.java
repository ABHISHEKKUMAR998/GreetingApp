package com.GreetingApp.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.GreetingConfigure.GreetingConfigure;

@Entity
@Table(name = "GREETINGS")
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)



	private long id;
	private String msg;
	
	public Greeting() {
		id = 0;
		msg = "";
	}

	

	public Greeting(long id, String message) {
		this.id = id;
		this.msg = message;
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
