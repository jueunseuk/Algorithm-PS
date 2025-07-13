package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int high[] = new int[9];
		int target = -100;
		
		for(int i = 0; i < 9; i++) {
			high[i] = Integer.parseInt(br.readLine());
			target += high[i];
		}
		
		Arrays.sort(high);
		
		boolean isTrue[] = new boolean[9];
		
		out:
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i != j && high[i]+high[j] == target) {
					isTrue[i] = true;
					isTrue[j] = true;
					break out;
				}
			}
		}
		
		for(int i = 0 ; i < 9; i++) {
			if(!isTrue[i]) {
				System.out.println(high[i]);
			}
		}
	}

}
