package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] origin = new int[n][m];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < m; j++) {
        		origin[i][j] = Integer.parseInt(st.nextToken());
        		min = Math.min(min, origin[i][j]);
        		max = Math.max(max, origin[i][j]);
        	}
        }
        
        int timeR = Integer.MAX_VALUE;
        int heightR = 0;
        
        for (int h = min; h <= max; h++) {
            int time = 0;
            int blocks = b;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = origin[i][j] - h;
                    if (diff > 0) {
                        time += diff * 2;
                        blocks += diff;
                    } else if (diff < 0) {
                        time += (-diff);
                        blocks += diff;
                    }
                }
            }

            if (blocks < 0) continue; // 블록이 부족한 경우 스킵

            if (time < timeR || (time == timeR && h > heightR)) {
            	timeR = time;
            	heightR = h;
            }
        }
        
        System.out.println(timeR+" "+heightR);
	}
}