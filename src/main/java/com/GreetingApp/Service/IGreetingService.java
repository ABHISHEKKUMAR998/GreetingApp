package com.GreetingApp.Service;

import java.util.List;

import com.GreetingApp.Model.Greeting;
import com.GreetingApp.Model.User;
import com.GreetingConfigure.GreetingConfigure;


public interface IGreetingService {
	
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAllGreetings();

	String deleteGreeting(long id);

	Greeting updateGreeting(long id, String message);
}
