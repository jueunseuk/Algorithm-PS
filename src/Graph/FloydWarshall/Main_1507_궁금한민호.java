package Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1507_궁금한민호 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = false;
                
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j && dist[i][j] == dist[i][k] + dist[k][j]) {
                    	flag = true;
                        break;
                    }
                }
                
                if (!flag) {
                    result += dist[i][j];
                }
            }
        }

        System.out.println(result);
	}
}