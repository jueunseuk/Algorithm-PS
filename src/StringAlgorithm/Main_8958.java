package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T; i++) {
			String input[] = br.readLine().split("");
			int result[] = new int[input.length];
			Arrays.fill(result, 0);
			
			int cnt = 1;
			for(int j = 0; j < input.length; j++) {
				if(input[j].equals("O")) {
					result[j] = cnt;
					cnt++;
				}
				else if(input[j].equals("X")){
					cnt = 1;
				}
			}
			
			
			int sum = 0;
			for(int j = 0; j < input.length; j++) {
				sum += result[j];
			}
			
			System.out.println(sum);
		}//outer_for
	}

}
