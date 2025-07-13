package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_9009_피보나치 {
	static int[] fibo = new int[46];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeFibo();
        
        int T = Integer.parseInt(br.readLine());
        
        int tc[] = new int[T];
        
        for(int t = 0; t < T; t++) {
        	tc[t] = Integer.parseInt(br.readLine());
        	
        	function(tc[t]);
        }
        
        br.close();
	}
	
	public static void function(int target) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 45; i > 0; i--) {
			if(target == 0) {
				break;
			}
			if(target >= fibo[i]) {
				list.add(fibo[i]);
				target -= fibo[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(list);
		
		for(int out : list) {
			sb.append(out).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
	
	public static void makeFibo() {
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i < 46; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
	}
}
