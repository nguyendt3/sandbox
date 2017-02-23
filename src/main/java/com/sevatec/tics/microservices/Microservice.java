package com.sevatec.tics.microservices;

public interface Microservice {
	public String healthCheck();
	public void findPrimes(int howMany);
}
