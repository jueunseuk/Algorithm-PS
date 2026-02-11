package Math.GCD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2485_가로수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int gcd = arr[1] - arr[0];
        for(int i = 2; i < n; i++) {
        	gcd = gcd(gcd, arr[i]-arr[i-1]);
        }

        int cnt = 0;
        for(int i = 1; i < n; i++) {
        	cnt += (arr[i] - arr[i-1]) / gcd - 1;
        }
        
        System.out.println(cnt);
	}

	public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}