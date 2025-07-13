package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3009 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] x = new int[3];
		int[] y = new int[3];
		
		for(int i = 0;  i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(x[0] == x[1] ? x[2] : x[0]).append(" ").append(y[0] == y[1] ? y[2] : y[0]);
		
		System.out.println(sb.toString());
	}

}
