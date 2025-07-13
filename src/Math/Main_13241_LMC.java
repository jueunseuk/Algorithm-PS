package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13241_LMC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long result;
		result = a*b/GCD(a, b);
		System.out.println(result);
	}

	private static long GCD(long a, long b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
