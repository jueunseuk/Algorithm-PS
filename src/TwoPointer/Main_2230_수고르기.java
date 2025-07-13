package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2230_수고르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		int minSub = Integer.MAX_VALUE;
		while(right < N && left < N) {
			int currentSub = arr[right]-arr[left];
			if(currentSub >= M) {
				minSub = Math.min(currentSub, minSub);
				left++;
			} else {
				right++;
			}
            if (left == right) {
                right++;
            }
		}
		
		System.out.println(minSub);
	}

}
