package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14916_거스름돈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n==1 || n==3) {
			System.out.println(-1);
			return;
		}
		
		int cnt = 0;
		
		cnt += n/5;
		n %= 5;
		
		if(n % 2 == 0) {
			cnt += n/2;
		} else {
			n+=5;
			cnt += n/2-1;
		}
		
		System.out.println(cnt);
	}

}
