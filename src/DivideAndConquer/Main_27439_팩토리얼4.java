package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_27439_팩토리얼4 {

    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }

    public static int exponentInFactorial(int n, int p) {
        int exponent = 0;
        long power = p;
        
        while (power <= n) {
            exponent += (n / power);
            power *= p;
        }
        
        return exponent;
    }

    public static BigInteger swingFactor(int n, List<Integer> primes) {
        if (n < 2) {
            return BigInteger.ONE;
        }
        
        int half = n / 2;
        BigInteger swingVal = BigInteger.ONE;

        for (int p : primes) {
            if (p > n) break;
            
            int expN = exponentInFactorial(n, p);
            int expHalf = exponentInFactorial(half, p);
            int leftover = expN - 2 * expHalf;
            
            if (leftover > 0) {
                swingVal = swingVal.multiply(BigInteger.valueOf(p).pow(leftover));
            }
        }
        
        return swingVal;
    }

    public static BigInteger primeSwingFactorial(int n) {
        List<Integer> primes = sieve(n);
        Map<Integer, BigInteger> cache = new HashMap<>();
        cache.put(0, BigInteger.ONE);
        cache.put(1, BigInteger.ONE);

        return factorialRecursive(n, primes, cache);
    }

    private static BigInteger factorialRecursive(int m, List<Integer> primes, Map<Integer, BigInteger> cache) {
        if (m < 2) {
            return BigInteger.ONE;
        }
        if (cache.containsKey(m)) {
            return cache.get(m);
        }
        int half = m / 2;
        BigInteger halfFact = factorialRecursive(half, primes, cache);
        BigInteger swg = swingFactor(m, primes);
        BigInteger result = halfFact.multiply(halfFact).multiply(swg);

        cache.put(m, result);
        return result;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger fact = primeSwingFactorial(Integer.parseInt(br.readLine()));
        System.out.println(fact);
    }
}
