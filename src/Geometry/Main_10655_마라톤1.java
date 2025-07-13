package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10655_마라톤1 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int coor[][] = new int[n][2];
        int sub[] = new int[n];
        int sum = 0;
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	coor[i][0] = Integer.parseInt(st.nextToken());
        	coor[i][1] = Integer.parseInt(st.nextToken());
        	
        	if(i > 0) {
        		sum += calc(coor[i][0], coor[i][1], coor[i-1][0], coor[i-1][1]);
        	}
        }
        
        for(int i = 1; i < n; i++) {
        	sub[i] = calc(coor[i][0], coor[i][1], coor[i-1][0], coor[i-1][1]);
        }
        
        int max = 0;
        for(int i = 2; i < n; i++) {
        	max = Math.max(max, Math.abs(calc(coor[i][0], coor[i][1], coor[i-2][0], coor[i-2][1]) - (sub[i]+sub[i-1])));
        }

        System.out.println(sum - max);
	}

	private static int calc(int i, int j, int k, int l) {
		return Math.abs(i-k)+Math.abs(j-l);
	}

}
