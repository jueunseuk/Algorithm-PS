package PrefixSum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 총 날짜
        int K = Integer.parseInt(st.nextToken()); // 구간의 길이
        
        int []temper = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) temper[i] = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        
        
        for(int i = 0 ; i < K; i++) sum += temper[i];
        int max = sum;
        
        for(int i = K; i < N; i++) {
        	sum += temper[i]-temper[i-K];
        	if(sum > max) max = sum;
        }
        
        System.out.println(max);
        
    }
}
