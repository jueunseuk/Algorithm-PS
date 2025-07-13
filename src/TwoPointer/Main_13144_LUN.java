package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13144_LUN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String input[] = br.readLine().split(" ");
		long arr[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int left = 0, right = 0, cnt = 0;
		while(left < right && right < n ) {
			
			
			
			int []temp = new int[right-left+1];
			
			
		}
		
		br.close();
	}

}
