package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9440_숫자더하기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int n = Integer.parseInt(st.nextToken());
        	if(n == 0) {
        		return;
        	}
        	
        	int[] arr = new int[n];
        	
        	for(int i = 0; i < n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(arr);
        	
        	StringBuilder sb = new StringBuilder();
        }

	}

}
