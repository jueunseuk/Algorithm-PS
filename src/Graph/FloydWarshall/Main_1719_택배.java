package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1719_택배 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [][][]result = new int[size+1][size+1][2];
        
        for(int i = 1; i <= size; i++) {
        	for(int j = 1; j <= size; j++) {
        		result[i][j][0] = 100000000;
        	}
        	result[i][i][0] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	result[start][end][0] = cost;
        	result[end][start][0] = cost;
        	result[start][end][1] = end;
        	result[end][start][1] = start;
        }
        
        for(int k = 1; k <= size; k++) {
        	for(int i = 1; i <= size; i++) {
        		for(int j = 1; j <= size; j++) {
        			if(result[i][j][0] > result[i][k][0]+result[k][j][0]) {
        				result[i][j][0] = result[i][k][0]+result[k][j][0];
        				result[i][j][1] = result[i][k][1];
        			}
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= size; i++) {
        	for(int j = 1; j <= size; j++) {
        		if(i == j) {
        			sb.append("- ");
        		} else {
        			sb.append(result[i][j][1]+" ");
        		}
        	}
        	sb.deleteCharAt(sb.length()-1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}