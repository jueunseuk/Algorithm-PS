package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12904_A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder target = new StringBuilder(br.readLine());
		StringBuilder input = new StringBuilder(br.readLine());
		
		while(input.length() > 0) {
			
			if(input.charAt(input.length()-1) == 'A') {
				input.deleteCharAt(input.length()-1);
			} else {
				input.deleteCharAt(input.length()-1);
				input.reverse();
			}

			if(input.toString().equals(target.toString())) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}

}
