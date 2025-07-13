package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25916_싫은데요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        int n = Integer.parseInt(st.nextToken()); // 구멍 개수
        int m = Integer.parseInt(st.nextToken()); // 햄스터 부피
        
        long arr[] = new long[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long max = 0L, curr = 0;
        int left = 0, right = 0;
        
        while(right < n) {
        	if(curr > m) {
        		curr -= arr[left];
        		left++;
        	} else {
        		curr += arr[right];
        		right++;
        	}
        	
        	if(curr <= m)
        	max = Math.max(max, curr);
        }
        
        System.out.println(max);
        br.close();
	}

}
