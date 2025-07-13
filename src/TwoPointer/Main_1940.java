package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int []input = new int[N];
		
		String []str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(str[i]); 
		
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(input[i]+input[j]==M) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
