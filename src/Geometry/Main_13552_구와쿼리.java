package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13552_구와쿼리 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int coor[][] = new int[n][3];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	coor[i][0] = Integer.parseInt(st.nextToken());
        	coor[i][1] = Integer.parseInt(st.nextToken());
        	coor[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        int sphere[][] = new int[m][4];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	sphere[i][0] = Integer.parseInt(st.nextToken());
        	sphere[i][1] = Integer.parseInt(st.nextToken());
        	sphere[i][2] = Integer.parseInt(st.nextToken());
        	sphere[i][3] = Integer.parseInt(st.nextToken());
        	
        	long radius = (long) sphere[i][3] * sphere[i][3];
        	
        	int cnt = 0;
        	for(int j = 0; j < n; j++) {
        		if(calc(coor[j][0], coor[j][1], coor[j][2], sphere[i][0], sphere[i][1], sphere[i][2]) <= radius) {
        			cnt++;
        		}
        	}
        	sb.append(cnt).append("\n");
        }
        
        System.out.println(sb.toString().trim());

	}
	
	public static long calc(long x1, long y1, long z1, long x2, long y2, long z2) {
		return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)+(z2-z1)*(z2-z1);
	}

}
