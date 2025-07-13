package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31813_RUNNUMBER {
	static long[] arr = new long[18];

	public static void main(String[] args) throws Exception {
		gen();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			
			while(K > 0) {
				long get = getMaxRun(K);
				K -= get;
				sb.append(get).append(" ");
				cnt++;
			}
			
			System.out.println(cnt);
			System.out.println(sb.toString().trim());
		}
	}
	
	private static void gen() {
		arr[1] = 1;
		for(int i = 2; i <= 17; i++) {
			arr[i] = arr[i-1]*10+1;
		}
	}

	public static long getMaxRun(long target) {
		long returns = 0;
		
		for(int i = 1; i <= 17; i++) {
			for(int j = 1; j <= 9; j++) {
				if(target < arr[i]*j) {
					break;
				}
				returns = arr[i]*j;
			}
		}
		
		return returns;
	}

}
