package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("app,repository,service,domain")
public class Application {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}

}
