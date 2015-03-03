package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/greeting")
public class HelloController {

	private final AtomicLong counter = new AtomicLong(1l);

	@RequestMapping(method = RequestMethod.GET)
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(
				"Hello, %s!", name));
	}
}
