package prime_number_generation.sieve_first_attempts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorStreams {
    public static void main(String[] args) {

        PrimeNumberGeneratorStreams p = new PrimeNumberGeneratorStreams();
        List<Integer> primes = p.getPrimes(50);
        primes.forEach(System.out::println);
    }

    public List<Integer> getPrimes(int numberOfWantedPrimes) {
        return IntStream.iterate(2, s -> s + 1)
                .filter(this::isPrime)
                .limit(numberOfWantedPrimes)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isPrime(int num) {
        //stream of divisors to check the number against
        return IntStream.rangeClosed(2, num / 2)
                .noneMatch(div -> num % div == 0);
    }
}
