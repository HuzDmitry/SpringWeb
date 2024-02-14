package by.CloudClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudClient3Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudClient3Application.class, args);
	}

}
