package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long sum = 0;
		int i = 0;
        
        while (sum <= N) {
            i++;
            sum += i;
        }
        
        System.out.println(i-1);
	}

}
