package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        if(n==1) {
        	System.out.println(1);
        	return;
        }
        
        int input[] = new int[n];
        
        int inDP[] = new int[n];
        int deDP[] = new int[n];
        
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        	inDP[i] = 1;
        	deDP[i] = 1;
        }
        
        int maxL = 0;
        for(int i = 1; i < n; i++) {
        	if(input[i] >= input[i-1]) {
        		inDP[i] = inDP[i-1]+1;
        	}
        	if (input[i] <= input[i-1]) {
        		deDP[i] = deDP[i-1]+1;
        	}
        	
        	maxL = Math.max(maxL, Math.max(inDP[i], deDP[i]));
        }
        
        System.out.println(maxL);

	}

}
