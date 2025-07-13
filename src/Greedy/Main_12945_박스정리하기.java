package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12945_박스정리하기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i = n-1; i >= n/2; i--) {
        	int idx = Arrays.binarySearch(arr, arr[i]/2);
        	System.out.println(idx);
        	if(idx >= 0) {
        		arr[idx] = 0;
        	} else {
        		arr[-idx] = 0;
        	}
    	}
        
        int cnt = 0;
        for(int out : arr) {
        	if(out != 0) cnt++;
        }
        
        System.out.println(cnt);
	}

}
