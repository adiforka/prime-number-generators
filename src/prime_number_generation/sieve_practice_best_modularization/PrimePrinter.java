package prime_number_generation.sieve_practice_best_modularization;

import java.util.List;

public class PrimePrinter {

    private final int numberOfPrimesPerRow;

    public PrimePrinter(int numberOfPrimesPerRow) {
        this.numberOfPrimesPerRow = numberOfPrimesPerRow;
    }

    public int getNumberOfPrimesPerRow() {
        return numberOfPrimesPerRow;
    }

    public void printPrimes(List<Integer> primesToPrint) {
        int printedCount = 0;
        for (Integer integer : primesToPrint) {
            if (++printedCount % numberOfPrimesPerRow == 0)
                System.out.printf("%3d\n", integer);
            else
                System.out.printf("%3d ", integer);
        }
    }
}
