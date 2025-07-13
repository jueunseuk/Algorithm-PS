package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int matrix[][];
	static int size, cnt = 0;
	
	// 가로, 대각선, 세로
	static int status[] = {1, 2, 3};
	static int dx[] = {1, 1, 0};
	static int dy[] = {0, 1, 1};
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        
        matrix = new int[size][size];
        
        StringTokenizer st;
        for(int i = 0; i < size; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < size; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs();
	}

	private static void bfs() {
		
	}

}
