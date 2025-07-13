package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_32621_동아리비횡령 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fail = "No Money";
		String success = "CUTE";
		
		String[] str = br.readLine().split("\\+");
		
		if(str.length < 2) {
			System.out.println(fail);
			return;
		}
		
		if(str[0].charAt(0) == '0' || str[1].charAt(0) == '0') {
			System.out.println(fail);
			return;
		}
		
		int front, back;
		
		try {
			front = Integer.parseInt(str[0]);			
			back = Integer.parseInt(str[1]);
			
			if(front == back) System.out.println(success);
			else System.out.println(fail);
			
			return;
			
		} catch (Exception e) {
			System.out.println(fail);
			return;
		}
				
	}
}
