package Graph.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16294_BeeProblem {
    static int row, col, k;
    static String[][] matrix;
    static boolean[][] visit;
    
    static int[] dx = {1, 1, -1, -1, 0, 0};
    static int[] dy = {1, -1, 1, -1, 2, -2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken()) * 2;
        
        matrix = new String[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if(i % 2 == 0) {
                for(int j = 0; j < col; j++) {
                    if(j % 2 == 0) {
                        matrix[i][j] = st.nextToken();
                    } else {
                        matrix[i][j] = " ";
                    }
                }
            } else {
                for(int j = 0; j < col; j++) {
                    if(j % 2 == 1) {
                        matrix[i][j] = st.nextToken();
                    } else {
                        matrix[i][j] = " ";
                    }
                }
            }
        }
        
        if (k == 0) {
            System.out.println(0);
            return;
        }
        
        List<Integer> compSizes = new ArrayList<>();
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visit[i][j] && ".".equals(matrix[i][j])) {
                    compSizes.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(compSizes, Collections.reverseOrder());
        
        int sum = 0;
        int idx;
        for(idx = 0; idx < compSizes.size(); idx++) {
            sum += compSizes.get(idx);
            if(sum >= k) {
                break;
            }
        }
        
        System.out.println(idx + 1);
    }
    
    static int bfs(int si, int sj) {
        Queue<int[]> queue = new ArrayDeque<>();
        visit[si][sj] = true;
        queue.offer(new int[]{si, sj});
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            
            int cx = cur[0];
            int cy = cur[1];
            
            for(int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                if(!visit[nx][ny] && ".".equals(matrix[nx][ny])) {
                    visit[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return count;
    }

}
