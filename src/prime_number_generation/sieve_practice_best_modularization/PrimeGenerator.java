package prime_number_generation.sieve_practice_best_modularization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGenerator {

    private final int upperPrimeLimit;

    public PrimeGenerator(int upperPrimeLimit) {
        this.upperPrimeLimit = upperPrimeLimit;
    }

    public int getUpperPrimeLimit() {
        return upperPrimeLimit;
    }

    public List<Integer> generatePrimes() {
        boolean[] falsifiedPrimes = falsifyBooleanOfAllPrimes();
        return generateListOfPrimes(falsifiedPrimes);
    }

    private boolean[] falsifyBooleanOfAllPrimes() {
        boolean[] falsifiedPrimes = new boolean[upperPrimeLimit + 1];
        Arrays.fill(falsifiedPrimes, true);

        for (int currentNum = 2; currentNum <= upperPrimeLimit; currentNum++)
            if (falsifiedPrimes[currentNum])
                for (int i = 2 * currentNum; i <= upperPrimeLimit; i += currentNum)
                    if (falsifiedPrimes[i])
                        falsifiedPrimes[i] = false;

        return falsifiedPrimes;
    }

    private List<Integer> generateListOfPrimes(boolean[] falsifiedPrimes) {
        List<Integer> primes = new ArrayList<>();
        for (int candidate = 2; candidate <= upperPrimeLimit; candidate++)
            if (falsifiedPrimes[candidate])
                primes.add(candidate);

        return primes;
    }
}
