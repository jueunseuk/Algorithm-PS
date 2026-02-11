package Math.GCD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2981_검문 {
	static int n;
	static int arr[];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int gcd = arr[1]-arr[0];
        for(int i = 2; i < n; i++) {
        	gcd = gcd(gcd, arr[i] - arr[i-1]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= gcd; i++) {
        	if(gcd % i == 0) {
        		sb.append(i).append(" ");
        	}
        }
        System.out.println(sb.toString().trim());
	}


	static int gcd(int a, int b) {
		while(b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
