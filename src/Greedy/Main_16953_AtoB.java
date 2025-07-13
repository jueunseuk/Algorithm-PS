package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953_AtoB {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		long origin = Long.parseLong(st.nextToken());
		long target = Long.parseLong(st.nextToken());
		
		int cnt = 1;
		
		while(target > origin) {
			
			long check = target % 10;
			
			if(check == 3 || check == 5 || check == 7 || check == 9) {
				System.out.println(-1);
				return;
			}
			
			if(check == 1) {
				target /= 10;
				cnt++;
				continue;
			}
			
			if(check % 2 == 0) {
				target /= 2;
				cnt++;
				continue;
			}
			
		}
		
		System.out.println(origin == target ? cnt : -1);
	}

}
