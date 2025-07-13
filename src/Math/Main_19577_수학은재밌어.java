package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_19577_수학은재밌어 {
	static final int MAX = 50000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());

		long ans = Long.MAX_VALUE;

		for (long k = 1; k * k <= n; k++) {
			if (n % k != 0) continue;

			long origin = k;
			long phi = k;
			for (long i = 2; i * i <= origin; i++) {
				if (origin % i == 0) {
					while (origin % i == 0) origin /= i;
					phi -= phi / i;
				}
			}
			if (origin > 1) phi -= phi / origin;
			if (k * phi == n) ans = Math.min(ans, k);

			long k2 = n / k;
			if (k2 != k) {
				origin = k2;
				phi = k2;
				
				for (long i = 2; i * i <= origin; i++) {
					if (origin % i == 0) {
						while (origin % i == 0) origin /= i;
						phi -= phi / i;
					}
				}
				
				if (origin > 1) phi -= phi / origin;
				if (k2 * phi == n) ans = Math.min(ans, k2);
			}
		}

		System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
	}
}
