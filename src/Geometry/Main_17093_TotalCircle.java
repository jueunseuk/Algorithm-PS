package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17093_TotalCircle {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int nn[][] = new int[n][2];
		int mm[][] = new int[m][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nn[i][0] = Integer.parseInt(st.nextToken());
			nn[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long max = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			mm[i][0] = Integer.parseInt(st.nextToken());
			mm[i][1] = Integer.parseInt(st.nextToken());
			
			for(int[] out : nn) {
				max = Math.max(max, calc(out[0], out[1], mm[i][0], mm[i][1]));
			}
		}
		
		System.out.println(max);
	}
	
	public static long calc(long x1, long y1, long x2, long y2) {
		return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
	}

}
