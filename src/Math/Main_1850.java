package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		BigInteger result = a.gcd(b);
		int intResult = result.intValue();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < intResult; i++) sb.append(1);
		
		System.out.println(sb);
		
	}
}
