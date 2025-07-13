package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int number = i;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum == N) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
        
        br.close();
	}
	


}
