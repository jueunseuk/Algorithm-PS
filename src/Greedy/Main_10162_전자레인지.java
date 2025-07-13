package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10162_전자레인지 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		br.close();
		
		if(T%10!=0) {
			System.out.println(-1);
			return;
		}
		
		int push[] = new int[3];
		while(T > 0) {
			if(T >= 300) {
				push[0] += T / 300;
				T %= 300;
			} else if(T >= 60) {
				push[1] += T / 60;
				T %= 60;
			} else {
				push[2] += T / 10;
				T %= 10;
			}
		}
		
		System.out.println(push[0]+" "+push[1]+" "+push[2]);
	}

}
