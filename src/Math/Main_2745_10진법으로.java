package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2745_10진법으로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int bin = Integer.parseInt(n, b);
		
		System.out.println(bin);
		
	}

}
