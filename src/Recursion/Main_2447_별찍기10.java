package Recursion;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2447_별찍기10 {
	static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }
        
        drawStar(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }

    private static void drawStar(int r, int c, int size) {
        if (size == 1) {
            board[r][c] = '*';
            return;
        }
        
        int newSize = size / 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                drawStar(r + i * newSize, c + j * newSize, newSize);
            }
        }
    }

}
