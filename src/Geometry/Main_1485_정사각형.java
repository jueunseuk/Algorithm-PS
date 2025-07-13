package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_1485_정사각형 {
	
    static long distSq(int x1, int y1, int x2, int y2) {
        long dx = x2 - x1;
        long dy = y2 - y1;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int[][] points = new int[4][2];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean duplicate = false;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) break;
            }
            
            if (duplicate) {
                sb.append(0).append("\n");
                continue;
            }

            long[] dist = new long[6];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dist[idx++] = distSq(points[i][0], points[i][1], 
                                         points[j][0], points[j][1]);
                }
            }
            
            Arrays.sort(dist);

            if (dist[0] != 0 &&
                dist[0] == dist[1] &&
                dist[1] == dist[2] &&
                dist[2] == dist[3] &&
                dist[4] == dist[5] &&
                dist[4] == 2 * dist[0]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}
