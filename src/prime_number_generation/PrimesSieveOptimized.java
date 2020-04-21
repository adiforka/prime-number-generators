package prime_number_generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//optimized for only odd numbers after 2 and also to falsify only true values (no multiple falsification)
public class PrimesSieveOptimized {
    public static void main(String[] args) {

        PrimesSieveOptimized s = new PrimesSieveOptimized();
        List<Integer> primes = s.generatePrimes(1000);
        System.out.println(primes);
        System.out.println(primes.size());
    }

    public List<Integer> generatePrimes(int maxNumber) {
        boolean[] checkedForPrimes = new boolean[maxNumber + 1];
        Arrays.fill(checkedForPrimes, true);

        //falsify all even numbers after 2 in one pass
        for (int p = 3; p < maxNumber; p++) {
            if (p % 2 == 0) {
                checkedForPrimes[p] = false;
            }
        }

        //all even numbers after 2 already falsified and 2 still true, so we don't need its multiples
        //too much nesting, should extract into separate methods
        for (int p = 3; p * p <= maxNumber; p++) {
            if (checkedForPrimes[p]) {
                for (int i = p * 2; i <= maxNumber; i += p) {
                    //avoid multiple falsifications of the same value in checkedForPrimes
                    //i.e. only assign the value of false to an index if it's still true
                    if (checkedForPrimes[i]) {
                        checkedForPrimes[i] = false;
                    }
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            if (checkedForPrimes[i])
                primes.add(i);
        }
        return  primes;
    }

}
