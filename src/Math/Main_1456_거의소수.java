package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1456_거의소수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = (int) Math.sqrt(B);
        // 1부터 max 까지 소수의 개수만큼만 배열 생성
        boolean[] isPrime = new boolean[max + 1];
        
        // 일단 모든 숫자가 소수라고 가정하고 true 로 할당
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        // 에라토스테네스의 체로 소수 구하기
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
            	// 배수 찾을때마다 소수 아니니까 false 할당
                for (long j = (long )i * i; j <= max; j += i) isPrime[(int) j] = false;
            }
        }

        int count = 0;

        // 소수의 거듭제곱을 계산하여 범위 내에 있는지 확인
        for (int i = 2; i <= max; i++) {
        	// 소수에 대해서만 확인
            if (isPrime[i]) {
                long power = (long) i * i;
                
                while (power <= B) {
                    if (power >= A) count++;
                    if (power > B / i) break; // overflow 방지
                    
                    power *= i;
                }//while
                
            }//if
        }//for

        System.out.println(count);
    }
}
