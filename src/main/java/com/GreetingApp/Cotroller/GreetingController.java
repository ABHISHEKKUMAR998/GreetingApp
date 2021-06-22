package com.GreetingApp.Cotroller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@RequestMapping("/get")
	public String greetingMessage() {
		return greetingService.getMessage();
	}
	@PostMapping("/post")
	public String greetUser(@RequestBody User user) {
		return greetingService.getMessage(user);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Greeting> getGreeting(@PathVariable Long id) {
		Greeting greeting = greetingService.getGreeting(id);
		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}

}

