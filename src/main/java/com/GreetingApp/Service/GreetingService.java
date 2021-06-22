package com.GreetingApp.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GreetingApp.Repository.IGreetingsRepository;
import com.GreetingConfigure.GreetingConfigure;
import com.GreetingApp.Model.Greeting;
import com.GreetingApp.Model.User;

	@Service
	public class GreetingService implements IGreetingService{
		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();
		@Autowired
		private IGreetingsRepository greetingRepository;

		@Override
		public Greeting addGreeting(User user) {
			String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
			return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
		}
		@Override
		public Greeting getGreetingById(long id) {
			return greetingRepository.findById(id).get();
		}
		@Override
		public List<Greeting> getAllGreetings() {
			return greetingRepository.findAll();
		}

		@Override
		public Greeting updateGreeting(long id, String message) {
			Greeting greet = this.getGreetingById(id);
			greet.setMessage(message);
			greetingRepository.save(greet);
			return this.getGreetingById(id);
		}

		@Override
		public String deleteGreeting(long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}