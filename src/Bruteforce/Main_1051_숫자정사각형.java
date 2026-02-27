package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++) {
        	arr[i] = br.readLine().toCharArray();
        }
        
        int max = 1;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		int curr = 1;
        		int size = Math.min(n-i, m-j);
        		for(int k = 0; k < size; k++) {
        			if(arr[i][j+k] == arr[i][j] && arr[i+k][j] == arr[i][j] && arr[i+k][j+k] == arr[i][j]) {
        				curr = Math.max(curr, (k+1)*(k+1));
        			}
        		}
        		
        		max = Math.max(max, curr);
        	}
        }
        
        System.out.println(max);
	}
}