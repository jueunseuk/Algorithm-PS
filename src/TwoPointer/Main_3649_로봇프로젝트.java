package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3649_로봇프로젝트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		long CENTI = 10_000_000L;
		
		int originTarget = Integer.parseInt(br.readLine());
		long target = originTarget * CENTI;
		
		int lego = Integer.parseInt(br.readLine());
		long arr[] = new long[lego];
		
		for(int i = 0; i < lego; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 0, right = lego-1;
		while(left < right) {
			long sum = arr[left] + arr[right];
			
			if(sum > target) {
				right--;
			} else if(sum < target) {
				left++;
			} else {
				System.out.println("yes "+arr[left]+" "+arr[right]);
				return;				
			}
		}
		System.out.println("danger");
		br.close();
	}

}
