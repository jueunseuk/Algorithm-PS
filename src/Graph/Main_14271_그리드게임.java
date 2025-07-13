package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14271_그리드게임 {
    static int row, col, time, cnt = 0;
    static char[][] matrix;
    static boolean[][] visit;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int input1 = Integer.parseInt(st.nextToken());
        int input2 = Integer.parseInt(st.nextToken());
        
        char[][] origin = new char[input1][input2];
        
        for(int i = 0; i < input1; i++) {
            origin[i] = br.readLine().toCharArray();
        }
        
        time = Integer.parseInt(br.readLine());
        
        row = input1 + time * 2;
        col = input2 + time * 2;
        matrix = new char[row][col];
        visit = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            Arrays.fill(matrix[i], '.');
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < input1; i++) {
            for(int j = 0; j < input2; j++) {
                matrix[i + time][j + time] = origin[i][j];
                if (matrix[i + time][j + time] == 'o') {
                    visit[i + time][j + time] = true;
                    q.offer(new int[] {i + time, j + time});
                    cnt++;
                }
            }
        }

        for(int k = 0; k < time; k++) {
            int size = q.size();
            
            for(int s = 0; s < size; s++) {
                int[] poll = q.poll();
                
                for(int delta = 0; delta < 4; delta++) {
                    int nx = poll[0] + dx[delta];
                    int ny = poll[1] + dy[delta];
                    
                    if(nx >= 0 && ny >= 0 && nx < row && ny < col) {
                        if(!visit[nx][ny] && matrix[nx][ny] == '.') {
                            visit[nx][ny] = true;
                            matrix[nx][ny] = 'o';
                            cnt++;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
}
