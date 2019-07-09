package Generators;

import Interface.PrimeNumberGeneratorInterface;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generates prime numbers using Sieve of Eratosthenes algorithm.
 * Runs in O(N^2) time.
 */
public class SieveGenerator implements PrimeNumberGeneratorInterface {
    private boolean [] isPrime;


    @Override
    public ArrayList<Integer> generatePrime(int lowerLimit, int upperLimit) {
        ArrayList<Integer> result = new ArrayList<>();

        lowerLimit = lowerLimit < 2 ? 2 : lowerLimit;
        // if it is a range such as (-100, 1), return empty list
        if (upperLimit < lowerLimit) return result;
        isPrime = new boolean[upperLimit + 1];
        Arrays.fill(isPrime, true);

        markComposites(upperLimit);

        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (isPrime[i]) result.add(i);
        }

        return result;
    }

//marks all the multiples of the prime as composites except the prime.
    private void markComposites(int upperLimit) {
        // start with the smallest prime number starting from 2
        int STARTING_POSITION = 2;

        for (int i = STARTING_POSITION; i * i <= upperLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= upperLimit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

