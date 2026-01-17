package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16480_외심과내심은사랑입니다 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long R = Integer.parseInt(st.nextToken());
        long r = Integer.parseInt(st.nextToken());
        
        System.out.println(R*(R-2*r));
	}
}