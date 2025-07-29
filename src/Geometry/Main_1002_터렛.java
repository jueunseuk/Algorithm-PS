package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002_터렛 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) {
					sb.append(-1);
				} else {
					sb.append(0);
				}
			} else {
				double calc = calc(x1, x2, y1, y2);
				double sum = r1 + r2;
				if(r2 > r1) {
					int temp = r1;
					r1 = r2;
					r2 = temp;
				}
				
				if(calc < r1) {
					if(calc+r2 < r1) {
						sb.append(0);
					} else if(calc+r2 > r1) {
						sb.append(2);
					} else {
						sb.append(1);
					}
				} else if(calc > r1) {
					if(sum > calc) {
						sb.append(2);
					} else if(sum < calc) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				} else {
					sb.append(2);
				}
				
			}
			
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}

	private static double calc(double x1, double x2, double y1, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
}