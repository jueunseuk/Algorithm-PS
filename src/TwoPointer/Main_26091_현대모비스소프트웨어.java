package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_26091_현대모비스소프트웨어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        int n = Integer.parseInt(st.nextToken()); // people
        int m = Integer.parseInt(st.nextToken());
        
        long arr[] = new long[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0, right = n-1, cnt = 0;
        while(left < right) {
        	long sum = arr[left] + arr[right];
        	
        	if(sum >= m) {
        		left++;
        		right--;
        		cnt++;
        	} else {
        		left++;
        	}
        }
        
        System.out.println(cnt);
        br.close();
	}

}
