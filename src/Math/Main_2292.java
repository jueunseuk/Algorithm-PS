package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2292 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		int i = 1;
		n -= 1;

		while(true) {
			if(n > 0) {
				n -= i*6;
				i++;				
			} else {
				System.out.println(i);
				return;
			}
		}
	}

}
