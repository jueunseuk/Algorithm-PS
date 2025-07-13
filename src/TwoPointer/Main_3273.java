package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int input[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int target = Integer.parseInt(br.readLine());
		
		Arrays.sort(input);
		
		int right = N-1, left = 0, cnt = 0;
		while(left < right) {
			int currentSum = input[left]+input[right];
			
			if (currentSum == target) {
                cnt++;
                left++;
                right--;
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
			
				
		}
		
		System.out.println(cnt);
	}

}
