package prime_number_generation.sieve_practice_best_modularization;

import java.util.List;

public class PrimeDemo {
    public static void main(String[] args) {

        PrimeGenerator generator = new PrimeGenerator(1000);
        List<Integer> generatedPrimes = generator.generatePrimes();

        PrimePrinter printer = new PrimePrinter(10);
        printer.printPrimes(generatedPrimes);
    }
}
