package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17290_크레이지아케이드 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;

        char[][] matrix = new char[10][10];
        
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        
        for(int i = 0; i < 10; i++) {
        	row.add(i);
        	col.add(i);
        }
        
        for(int i = 0; i < 10; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < 10; j++) {
        		if(matrix[i][j] == 'o') {
        			row.remove(i);
        			col.remove(j);
        		}
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for(int i : row) {
        	for(int j : col) {
        		min = Math.min(min, Math.abs(i-x)+Math.abs(j-y));
        	}
        }
        
        System.out.println(min);
	}

}
