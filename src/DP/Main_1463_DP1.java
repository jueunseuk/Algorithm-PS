package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_DP1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int []arr = new int[N+1];
		
		arr[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-1]+1;
			
			if(i%2==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if(i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		
		System.out.println(arr[N]);
	}

}
