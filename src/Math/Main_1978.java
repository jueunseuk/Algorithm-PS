package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []number = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(number);

        boolean[] isPrime = new boolean[1001];

        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i * i < 1001; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1001; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < N; i++) {
        	if(isPrime[number[i]]) {
        		cnt++;
        	}
        }
        System.out.println(cnt);
    }
}
