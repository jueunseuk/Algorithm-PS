package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_23560_약 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] a = new long[16];
        long[] b = new long[16];

        a[1] = 2;
        b[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = 2 * a[i - 1] + 2 * b[i - 1];
            b[i] = b[i - 1] + a[i - 1];
        }

        System.out.println(a[(int) n]);

	}

}
