package StringAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2902_KMP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken().charAt(0));
		}
		
		System.out.println(sb.toString().trim());
	}
}