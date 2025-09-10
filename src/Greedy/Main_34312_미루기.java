package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_34312_미루기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] input = new int[n][2];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	input[i][0] = Integer.parseInt(st.nextToken());
        	input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
        });
        
        long score = 0;
        for(int i = 0; i < n; i++) {
        	if(T - input[i][0] < 0) {
        		break;
        	}
        	
        	T -= input[i][0];
        	score += input[i][1];
        }
        
        System.out.println(score);
	}
}