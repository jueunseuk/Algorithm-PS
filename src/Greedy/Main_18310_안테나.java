package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18310_안테나 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n];
        
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        int min = 0;
        int num = input[min];
        for(int i = 1; i < n; i++) {
        	min += input[i]-input[i-1];
        }
        
        for(int i = 1; i < n; i++) {
        	int calc = 0;
        	int gap = input[i]-input[i-1];
        	
        	calc += gap*i;
        	calc -= gap*(n-i-1);
        	
        	if(calc < min) {
        		min = calc;
        		num = input[i];
        	}
        }
        
        System.out.println(num);
	}

}
