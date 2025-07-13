package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        boolean[][] matrix = new boolean[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		if(st.nextToken().equals("1")) {
        			matrix[i][j] = true;
        		}
        	}
        }
        
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
        		}
        	}
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j]) {
        			sb.append(1+" ");
        		} else {
        			sb.append(0+" ");
        		}
        	}
        	sb.deleteCharAt(sb.length()-1).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}