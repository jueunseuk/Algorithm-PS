package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1564_팩토리얼5 {
	static long value = 1;
	static final long MOD = 1000000000000l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			value *= i;
			remove();
			value %= MOD;
		}

		int length = 5-String.valueOf(value%100000).length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append("0");
		}
		sb.append(value%100000);
		System.out.println(sb.toString().trim());
	}

	private static void remove() {
		while(value % 10 == 0) {
			value /= 10;
		}
	}
}