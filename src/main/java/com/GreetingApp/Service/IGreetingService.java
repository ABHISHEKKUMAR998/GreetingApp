package com.GreetingApp.Service;

import com.GreetingApp.Model.Greeting;
import com.GreetingApp.Model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
}
