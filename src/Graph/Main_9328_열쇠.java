package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {
	static int row, col;
	static char[][] matrix;
	static boolean[][][] visit;
	static Queue<int[]> q;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	row = Integer.parseInt(st.nextToken());
        	col = Integer.parseInt(st.nextToken());
        	
        	matrix = new char[row][col];
        	visit = new boolean[row][col][1 << 26];
        	q = new ArrayDeque<>();
        	
        	for(int i = 0; i < row; i++) {
        		matrix[i] = br.readLine().toCharArray();
        	}
        	
        	char[] init = br.readLine().toCharArray();
        	
        	int initKey = 0;
        	if(init[0] != '0') {
        		for(int i = 0; i < init.length; i++) {
        			initKey |= init[i]-'a';
        		}
        	}
        	System.out.println(initKey);
        }
	}

}