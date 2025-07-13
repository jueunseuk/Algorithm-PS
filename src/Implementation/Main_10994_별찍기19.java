package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10994_별찍기19 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int size = 4 * N - 3;
        char[][] board = new char[size][size];
        
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }
        
        for (int layer = 0; layer < N; layer++) {
            int start = 2 * layer;
            int end   = size - 2 * layer - 1;
            
            for (int col = start; col <= end; col++) {
                board[start][col] = '*';
                board[end][col]   = '*';
            }
            for (int row = start; row <= end; row++) {
                board[row][start] = '*';
                board[row][end]   = '*';
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }
}
