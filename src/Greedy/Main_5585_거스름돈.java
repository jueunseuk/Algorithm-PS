package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585_거스름돈 {
	public static int[] m = {1, 5, 10, 50, 100, 500};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = 1000 - Integer.parseInt(br.readLine());
		br.close();
		
		int i = 5;
		int cnt = 0;
		while(target > 0) {
			if(target / m[i] == 0) {
				target = target % m[i];
				i--;
			} else {
				cnt += target/m[i];
				target = target % m[i];
			}
			
		}
		
		System.out.println(cnt);
	}

}
