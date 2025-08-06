package Graph.FloydWarshall;
import java.io.*;
import java.util.*;

public class Main_11562_백양로브레이크 {

    static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] result = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) Arrays.fill(result[i], INF);
        for (int i = 1; i <= n; i++) result[i][i] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 1) {
                result[u][v] = result[v][u] = 0;
            } else {
                result[u][v] = 0;
                result[v][u] = 1;
            }
        }

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (result[i][j] > result[i][k] + result[k][j])
                        result[i][j] = result[i][k] + result[k][j];

        int q = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            sb.append(result[s][e]).append('\n');
        }
        
        System.out.print(sb.toString().trim());
    }
}
