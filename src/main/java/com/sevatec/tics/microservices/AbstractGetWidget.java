package com.sevatec.tics.microservices;

public class AbstractGetWidget implements Microservice {

	@Override
	public String healthCheck() {
		return "Healthy";
	}

	@Override
	public void findPrimes(int howMany) {
		int howManyFound = 0;
		int currentlyAt = 2;
		
		while(howManyFound < howMany) {
			if(isPrime(currentlyAt++)) {
				howManyFound++;
			}
		}
	}

	private boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
