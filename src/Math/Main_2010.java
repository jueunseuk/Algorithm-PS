package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += num[i];
		}
		
		System.out.println(sum-N+1);
	}

}
