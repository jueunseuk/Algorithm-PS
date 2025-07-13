package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2847_게임을만든동준이 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] input = new int[n];
        
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(br.readLine());
        }
        
        int cnt = 0;
        for(int i = n-2; i >= 0; i--) {
        	while(input[i] >= input[i+1]) {
        		input[i]--;
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}

}
