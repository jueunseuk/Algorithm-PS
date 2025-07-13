package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int initial = N;
		int sum, cnt = 0;
		
		do {
			sum = N/10+N%10;
			N = N%10*10+sum%10;
			cnt++;
		}while(initial != N);
		
		
		System.out.println(cnt);
		
	}

}
