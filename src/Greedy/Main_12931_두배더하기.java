package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12931_두배더하기 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int []input = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        
        while(true) {
        	if(isZero(input)) {
        		System.out.println(cnt);
        		return;
        	}
        	
        	boolean checkEven = true;
        	
        	for(int i = 0; i < input.length; i++) {
        		if(input[i] % 2 == 1) {
        			checkEven = false;
        			break;
        		}
        	}
        	
        	if(checkEven) {
        		for(int i = 0; i < input.length; i++) {
            		input[i] /= 2;
            	}
        		cnt++;
        	} else {
        		for(int i = 0; i < input.length; i++) {
        			if(input[i] % 2 == 1) {
        				input[i]--;
        				cnt++;
        			}
        		}
        	}
        	
        }
	}
	
	public static boolean isZero(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				return false;
			}
		}
		return true;
		
	}
}
