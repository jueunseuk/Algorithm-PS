package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11976_PromotionCounting {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] matrix = new int[4][2];
        
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	matrix[i][0] = Integer.parseInt(st.nextToken());
        	matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int gtp = matrix[3][1] - matrix[3][0];
        
        matrix[2][0] -= gtp;
        
        int stg = matrix[2][1] - matrix[2][0];
        
        matrix[1][0] -= stg;
        
        int bts = matrix[1][1] - matrix[1][0];
        
        System.out.println(bts);
        System.out.println(stg);
        System.out.println(gtp);
	}
}