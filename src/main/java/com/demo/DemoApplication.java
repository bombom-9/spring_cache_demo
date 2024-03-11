package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	VM Options
//	-Djdk.attach.allowAttachSelf=true
//	--add-opens=java.base/java.util=ALL-UNNAMED
//	--add-opens=java.base/java.lang=ALL-UNNAMED

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
