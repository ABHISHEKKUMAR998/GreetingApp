package com.GreetingApp.Service;

import com.GreetingApp.Model.Greeting;
import com.GreetingApp.Model.User;

public interface IGreetingService {
	
	String getMessage();

	String getMessage(User user);
	Greeting saveGreeting(GreetingConfigure greetingconfig);
}
