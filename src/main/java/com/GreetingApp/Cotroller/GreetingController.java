package com.GreetingApp.Cotroller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GreetingApp.Model.Greeting;
import com.GreetingApp.Model.User;
import com.GreetingApp.Service.GreetingService;
import com.GreetingApp.Service.IGreetingService;


/*@RequestParam for accessing HTTP
* request query parameters. 
*/
@RestController
@RequestMapping("/greeting")

public class GreetingController {
	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	/* @Autowired
	 * This annotation is applied to fields, setter methods, and constructors.
	 * The @Autowired annotation injects object dependency implicitly.
	 */

	@Autowired
	private GreetingService greetingService;
	@GetMapping(value = { "", "/", "/home" })
	public Greeting getGreeting(@RequestParam(value = "fName", defaultValue = "") String firstName,
			@RequestParam(value = "lName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}
	@GetMapping(value = { "/{id}", "/home/{id}" })
	public Greeting getGreeting(@PathVariable long id) {
		return greetingService.getGreetingById(id);
	}
	@PostMapping("/post")
	public String getGreeting(@RequestBody Greeting greeting) {
		return "{\"id\":" + greeting.getId() + ",\"message\":" + "\"" + String.format(template, greeting.getMessage())
				+ "\"}";
	}
	@PutMapping("/put/{id}")
	public Greeting getGreeting(@PathVariable long id,
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(id, String.format(template, name));
	}
	@PutMapping("/put")
	public Greeting updateGreeting(@RequestParam(value = "id") long id,
			@RequestParam(value = "message", defaultValue = "")String message) {
		return greetingService.updateGreeting(id, message);		
	}	

}

