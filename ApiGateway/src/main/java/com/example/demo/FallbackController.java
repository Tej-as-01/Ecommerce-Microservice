package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	// Fallback response when Product Service is unavailable
	@GetMapping("/fallback/products")
	public Mono<String> productServiceFallback()
	{
		return Mono.just("Product service is not available. Try again later");
	}
	
	// Fallback response when Order Service is unavailable
	@GetMapping("/fallback/order")
	public Mono<String> orderServiceFallback()
	{
		return Mono.just("Order service is not available. Try again later");
	}

}
