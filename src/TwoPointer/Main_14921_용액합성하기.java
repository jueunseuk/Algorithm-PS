package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14921_용액합성하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String []input = br.readLine().split(" ");
		Long []arr = new Long[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(input[i]);
		}
		
		int left = 0, right = n-1;
		Long min = Long.MAX_VALUE;
		while(left < right) {
			Long sum = arr[left] + arr[right];
			
			if(sum > 0) {
				if(min > 0) {
					min = Math.min(min, sum);
				} else {
					if(0 - min > sum) {
						min = sum;
					}
				}
				right--;
			} else if(sum < 0) {
				if(min > 0) {
					if(0 - sum < min) {
						min = sum;
					}
				} else {
					min = Math.max(min, sum);
				}
				left++;
			} else {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(min);
	}

}
