package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int data;
		
		while((data = br.read()) != -1) {
			sb.append((char) data);
		}
		
		System.out.println(sb.toString());
	}

}
