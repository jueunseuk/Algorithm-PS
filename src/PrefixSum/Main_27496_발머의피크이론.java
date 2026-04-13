package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27496_발머의피크이론 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int lasting = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        int curr = 0;
        for(int i = 0; i < lasting; i++) {
        	curr += arr[i];
        	if(curr >= 129 && curr <= 138) {
        		cnt++;
        	}
        }
        
        int left = 0;
        int right = lasting;
        while(right < n) {
        	curr += arr[right++];
        	curr -= arr[left++];
        	
        	if(curr >= 129 && curr <= 138) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}
}