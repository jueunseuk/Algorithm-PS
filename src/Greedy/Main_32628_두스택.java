package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_32628_두스택 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		long asum[] = new long[n];
		long bsum[] = new long[n];
		
		asum[0] = a[0];
		for(int i = 1; i < n; i++) {
			asum[i] += asum[i-1] + a[i];
		}
		
		bsum[0] = b[0];
		for(int i = 1; i < n; i++) {
			bsum[i] += bsum[i-1] + b[i];
		}
				
		long min = Long.MAX_VALUE;
		for(int i = 0; i <= k; i++) {
			int na = n-1-i, nb = n-1-k+i;
			long nsuma, nsumb;
			
			if(na < 0) nsuma = 0;
			else nsuma = asum[na];
			
			if(nb < 0) nsumb = 0;
			else nsumb = bsum[nb];
			
			min = Math.min(Math.max(nsuma, nsumb), min);
		}
		
		System.out.println(min);
	}

}
