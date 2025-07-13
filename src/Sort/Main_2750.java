package Sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		for(int output : input)
		System.out.println(output);
	}

}
