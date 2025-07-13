package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_24513_좀비바이러스 {
    static int row, col;
    static int[][] matrix;
    
    static Queue<int[]> virus1 = new ArrayDeque<>();
    static Queue<int[]> virus2 = new ArrayDeque<>();
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < col; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 1) {
                    virus1.offer(new int[]{i, j});
                }
                else if(matrix[i][j] == 2) {
                    virus2.offer(new int[]{i, j});
                }
            }
        }

        while(!virus1.isEmpty() || !virus2.isEmpty()) {
            boolean anySpread = spreadOneRound();
            if(!anySpread) {
                break;
            }
        }

        int count1 = 0, count2 = 0, count3 = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1) count1++;
                else if(matrix[i][j] == 2) count2++;
                else if(matrix[i][j] == 3) count3++;
            }
        }

        System.out.println(count1 + " " + count2 + " " + count3);
    }

    private static boolean spreadOneRound() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int size1 = virus1.size();
        for(int i = 0; i < size1; i++){
            int[] pos = virus1.poll();
            int r = pos[0], c = pos[1];

            for(int d = 0; d < 4; d++){
                int nr = r + dx[d];
                int nc = c + dy[d];
                
                if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;
                if(matrix[nr][nc] == 0) {
                    int encode = nr * col + nc;
                    set1.add(encode);
                }
            }
        }

        int size2 = virus2.size();
        for(int i = 0; i < size2; i++){
            int[] pos = virus2.poll();
            int r = pos[0], c = pos[1];

            for(int d = 0; d < 4; d++){
                int nr = r + dx[d];
                int nc = c + dy[d];
                
                if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;
                if(matrix[nr][nc] == 0) {
                    int encode = nr * col + nc;
                    set2.add(encode);
                }
            }
        }

        Set<Integer> set3 = new HashSet<>(set1);
        set3.retainAll(set2);
        set1.removeAll(set3);
        set2.removeAll(set3);

        if(set1.isEmpty() && set2.isEmpty() && set3.isEmpty()) {
            return false;
        }

        for(int v : set3) {
            int r = v / col;
            int c = v % col;
            matrix[r][c] = 3;
        }
        for(int v : set1) {
            int r = v / col;
            int c = v % col;
            matrix[r][c] = 1;
            virus1.offer(new int[]{r, c});
        }
        for(int v : set2) {
            int r = v / col;
            int c = v % col;
            matrix[r][c] = 2;
            virus2.offer(new int[]{r, c});
        }

        return true;
    }
}