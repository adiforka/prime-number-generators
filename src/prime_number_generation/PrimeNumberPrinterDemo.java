package prime_number_generation;

public class PrimeNumberPrinterDemo {
    public static void main(String[] args) {

        //print first 50 prime numbers, 10 per line
        final var ITEMS_PER_LINE = 10;
        int[] primes = getPrimes(50, ITEMS_PER_LINE);

        for (int i = 0; i < primes.length; i++) {
            if ((i + 1) % ITEMS_PER_LINE == 0) System.out.printf("%4d\n", primes[i]);
            else System.out.printf("%4d", primes[i]);

        }
    }

    static int[] getPrimes(int numberOfWantedPrimes, int ITEMS_PER_LINE) {

        int[] primes = new int[numberOfWantedPrimes];

        int count = 0;
        int candidate = 1;

        while (count < numberOfWantedPrimes) {
            if (isPrime(candidate)) {
                primes[count] = candidate;
                count++;
                //a way to print the results here
                /*if (count % ITEMS_PER_LINE == 0) System.out.printf("%3d\n", candidate);
                else System.out.printf("%3d ", candidate);*/
            }
            candidate++;
        }
        return primes;
    }

    private static boolean isPrime(int num) {

        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) return false;
        }
        return true;
    }
}
