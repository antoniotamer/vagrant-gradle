package hello;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class HelloControllerIntegrationTest {

	private static final int PORT = 8888;

	private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + PORT + "/greeting");
		template = new RestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		String response = template.getForObject(base.toString(), String.class);
		assertThat(response, containsString("Hello"));
	}
}