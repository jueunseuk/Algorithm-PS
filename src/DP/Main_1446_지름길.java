package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1446_지름길 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        int D = Integer.parseInt(st.nextToken()); // 도착 지점

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i; // 초기화: i까지의 최단 거리는 일단 i로 설정
        }

        // 지름길 정보를 저장
        int[][] shortcuts = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end <= D) {
                shortcuts[i][0] = start;
                shortcuts[i][1] = end;
                shortcuts[i][2] = length;
            }
        }

        // DP를 이용해 최단 거리 계산
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 기본적인 1칸 이동
            }

            // 각 지름길을 적용
            for (int[] shortcut : shortcuts) {
                int start = shortcut[0];
                int end = shortcut[1];
                int length = shortcut[2];

                if (i == start && end <= D) {
                    dp[end] = Math.min(dp[end], dp[start] + length);
                }
            }
        }

        System.out.println(dp[D]);
    }
}
