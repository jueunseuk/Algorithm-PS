package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1271_엄청난부자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger first = new BigInteger(st.nextToken());
		BigInteger second = new BigInteger(st.nextToken());
		
		System.out.println(first.divide(second));
		System.out.println(first.mod(second));
	}
}
