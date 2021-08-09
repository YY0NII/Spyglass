package com.codedifferently.group2.Spyglass;

import com.codedifferently.group2.Spyglass.Property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpyglassApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpyglassApplication.class, args);
	}

}
