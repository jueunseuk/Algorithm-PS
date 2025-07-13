package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split("");
			
			int input[] = new int[str.length];
			for(int i = 0; i < input.length; i++) {
				input[i] = Integer.parseInt(str[i]);
			}
			if(input[0] == 0) return;
			
			boolean is = true;
			int length = input.length;
			if(input[length-1] == 0) {
				System.out.println("no");
				continue;
			}
			else {
				for(int i = 0; i < length/2; i++) {
					if(input[i]!=input[length-i-1]) {
						is = false;
						break;
					}
				}
				
				if(!is) System.out.println("no");
				else System.out.println("yes");
			}
			
		}
	}

}
