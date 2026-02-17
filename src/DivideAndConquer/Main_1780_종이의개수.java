package DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int n, m, z, p;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        dac(0, 0, n);
        
        System.out.println(m);
        System.out.println(z);
        System.out.println(p);
	}

	private static void dac(int sx, int sy, int length) {
		if(length == 1) {
			if(arr[sx][sy] == -1) {
				m++;
			} else if(arr[sx][sy] == 0) {
				z++;
			} else {
				p++;
			}
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		out:
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				set.add(arr[sx+i][sy+j]);
				if(set.size() > 1) break out;
			}
		}
		
		int newL = length/3;
		if(set.size() > 1) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					dac(sx+i*newL, sy+j*newL, newL);
				}
			}
		} else {
			if(set.contains(-1)) {
				m++;
			} else if(set.contains(0)) {
				z++;
			} else {
				p++;
			}
			return;
		}
	}
}