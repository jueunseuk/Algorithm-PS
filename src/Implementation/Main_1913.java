package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        int[][] snail = new int[N][N];
        int num = N * N;  // 시작 숫자
        int mX = -1, mY = -1; // M의 위치 저장

        int x = 0, y = 0; // 시작점
        int[] dx = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
        int[] dy = {0, 1, 0, -1}; 
        int direction = 0; // 초기 방향: 아래

        while (num > 0) {
            snail[x][y] = num;
            if (num == M) {
                mX = x;
                mY = y;
            }
            num--;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 배열 범위를 벗어나거나 이미 채워진 경우 방향 전환
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0) {
                direction = (direction + 1) % 4; // 방향 전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snail[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append((mX + 1)).append(' ').append((mY + 1)).append('\n');
        System.out.println(sb);
    }
}
