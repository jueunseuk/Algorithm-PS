package Bruteforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 0;
		
		while(true) {
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			
			if(cnt == N) break;
			num++;
		}
		
		System.out.println(num);
	}

}
