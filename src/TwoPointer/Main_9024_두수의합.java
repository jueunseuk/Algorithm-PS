package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9024_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long arr[] = new long[1000000];
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			// 숫자 개수랑 타겟 값
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			long target = Long.parseLong(st.nextToken());
	        
			// 배열에 숫자 할당
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int i = 0; i < n; i++) {
	        	arr[i] = Long.parseLong(st.nextToken());
	        }
	        Arrays.sort(arr, 0, n);
	        
	        int right = n-1, left = 0;
	        long cnt = 0, min = Long.MAX_VALUE;
	        
	        // 투 포인터
	        while(right > left) {
	        	// 합
	        	long sum = arr[right] + arr[left];
	        	long sub = Math.abs(sum - target);
	        	if(sub < min) {
                    min = sub;
                    cnt = 1;
                } else if(sub == min) {
                    cnt++;
                }
                    
                if(sum < target) {
                    left++;
                } else if(sum > target) {
                    right--;
                } else {
                    left++;
                    right--;
                }
	        }
	        
	        System.out.println(cnt);
		}
		
		br.close();
	}

}
