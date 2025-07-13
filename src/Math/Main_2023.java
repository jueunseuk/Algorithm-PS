package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023 {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 첫 자리수는 반드시 2, 3, 5, 7
        findInterestingPrimes(2, 1);
        findInterestingPrimes(3, 1);
        findInterestingPrimes(5, 1);
        findInterestingPrimes(7, 1);
    }
    
    static void findInterestingPrimes(int num, int digit) {
        if (digit == N) {
            System.out.println(num);
            return;
        }

        // 다음 자리수는 홀수만 고려
        for (int i = 1; i <= 9; i += 2) {
            int newNum = num * 10 + i;
            if (isPrime(newNum)) {
                findInterestingPrimes(newNum, digit + 1);
            }
        }
    }

    // 소수 판별
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
