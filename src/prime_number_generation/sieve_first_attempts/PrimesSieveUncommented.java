package prime_number_generation.sieve_first_attempts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesSieveUncommented {
    public static void main(String[] args) {
        PrimesSieveUncommented p = new PrimesSieveUncommented();
        List<Integer> primes = p.getPrimesWithSieveOfEratosthenes(300);
        System.out.println(primes);

    }

    public List<Integer> getPrimesWithSieveOfEratosthenes(int maxNoChecked) {

        boolean[] primeChecks = new boolean[maxNoChecked + 1];
        Arrays.fill(primeChecks, true);

        for (int p = 2; p * p <= maxNoChecked; p++) {
            if (primeChecks[p]) {
                for (int i = p * 2; i <= maxNoChecked; i += p) {
                    primeChecks[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxNoChecked; i++) {
            if (primeChecks[i])
                primes.add(i);
        }
        return primes;
    }
}
