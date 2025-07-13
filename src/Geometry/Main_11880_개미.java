package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11880_개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			long case1 = (a + b) * (a + b) + c * c;
            long case2 = (a + c) * (a + c) + b * b;
            long case3 = (b + c) * (b + c) + a * a;
            
            long min = Math.min(case1, Math.min(case2, case3));
            sb.append(min).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}