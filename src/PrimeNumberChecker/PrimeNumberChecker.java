package PrimeNumberChecker;

public class PrimeNumberChecker {

    public boolean isPrime(int number) {

        boolean isPrime = true;
        
        if (number <= 1) {
            isPrime = false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
