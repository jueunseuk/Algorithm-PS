package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_31474_양갈래짝맞추기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        long result = 1;

        for (int i = n - 1; i > 1; i -= 2) {
            result *= i;
        }

        System.out.println(result);
	}
}