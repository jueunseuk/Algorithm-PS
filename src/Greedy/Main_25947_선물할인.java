package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_25947_선물할인 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int budget = Integer.parseInt(st.nextToken());
        int sale = Integer.parseInt(st.nextToken());
        
        int input[] = new int[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        int sum[] = new int[n];
        sum[0] = input[0];
        
        for(int i = 1; i < n; i++) {
        	sum[i] += input[i];
        }
        
        
	}

}
