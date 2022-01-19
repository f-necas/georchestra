package com.example.http2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Http2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Http2DemoApplication.class, args);
	}
	
	@GetMapping
    public String test() {
        return "hello HTTP/2";
    }
}
