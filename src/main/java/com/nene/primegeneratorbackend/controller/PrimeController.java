package com.nene.primegeneratorbackend.controller;

import com.nene.primegeneratorbackend.model.PrimeResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PrimeController implements PrimeApiDocs {

    @Override
    @Async
    @Cacheable("primes")
    public PrimeResponse getPrimesUpToLimit(int num) {
        List<Integer> primes = calculatePrimes(num);
        return new PrimeResponse(primes, num); // Return the wrapper object
    }

    private List<Integer> calculatePrimes(int num) {
        List<Integer> primes = new ArrayList<>();
        if (num < 2) {
            return primes;
        }

        boolean[] isPrime = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= num; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= num; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
