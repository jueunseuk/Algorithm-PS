package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int data;
		int []map = new int[26];
		
		while((data = br.read()) >= 97) {
			map[data - 97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 26; i++) {
			sb.append(map[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
