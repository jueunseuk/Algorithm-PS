package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int a, b;
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), ",");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sb.append(a+b).append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
		br.close();
	}

}
