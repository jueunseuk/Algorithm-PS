package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String []str = br.readLine().split(" ");
			
			int input[] = new int[3];
			for(int i = 0; i < 3; i++) input[i] = Integer.parseInt(str[i]);
			
			if(input[0]==0) return;
			Arrays.sort(input);
			
			if(input[0]*input[0]+input[1]*input[1] == input[2]*input[2]) System.out.println("right");
			else System.out.println("wrong");
		}
	}

}
