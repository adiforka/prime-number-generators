package prime_number_generation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimesSieveOfEratosthenes {
    public static void main(String[] args) {

        PrimesSieveOfEratosthenes sieve = new PrimesSieveOfEratosthenes();
        List<Integer> primes = sieve.getPrimesWithSieveOfEratosthenes(300);
        System.out.println(primes);
    }

    public List<Integer> getPrimesWithSieveOfEratosthenes(int maxNoChecked) {
        //length of the array + 1 because we do want to check the maxNoChecked (and it's an exclusive bound)
        boolean[] primeChecks = new boolean[maxNoChecked + 1];
        //fill check array with all true values and falsify as you eliminate candidates as composite numbers
        Arrays.fill(primeChecks, true);
        //this is how long we'll be checking (p <= square root of maxNoChecked)
        for (int p = 2; p * p <= maxNoChecked; p++) {
            //if value in boolean array primes not already marked as false (composite no.)
            //if it is already false, i.e., not a prime, move to the next p
            if (primeChecks[p]) {
                //then multipliers for it and mark them in the primes list as false
                // e.g. if p = 5, then i is initially 2 * p = 10, then 10 + p = 15, then 15 + p = 20
                //i.e., you multiply p by consecutive integers starting with 2 until you get to or past the max
                //candidate
                for (int i = p * 2; i <= maxNoChecked; i += p) {
                    primeChecks[i] = false;
                }
            }
        }

        //add indexes of all the true values in primeChecks as prime integers in the list
        //which to return to the caller
        List<Integer> primes = new LinkedList<>();

        for (int i = 2; i <= maxNoChecked; i++) {
            if (primeChecks[i])
                primes.add(i);
        }
        return primes;
    }
}
