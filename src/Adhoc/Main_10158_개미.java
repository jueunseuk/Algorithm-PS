package Adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());

		int nx = (p + t) % (2 * w);
		if (nx > w) nx = 2 * w - nx;

		int ny = (q + t) % (2 * h);
		if (ny > h) ny = 2 * h - ny;

		System.out.println(nx + " " + ny);
	}
}