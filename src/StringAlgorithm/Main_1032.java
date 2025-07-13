package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String []origin = br.readLine().split("");
		
		int size = origin.length;
		
		for(int t = 1; t < T; t++) {
			String []input = br.readLine().split("");
			
			for(int i = 0; i < size; i++) {
				if(!origin[i].equals(input[i])) origin[i] = "?";
			}
		}
		
		for(String out : origin) {
			System.out.print(out);
		}
	}

}
