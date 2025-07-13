package Recursion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {

    public static int Z(int n, int r, int c) {
        if (n == 0) return 0;

        int half = 1 << (n - 1); // 2^(n-1)
        // 분할된 정사각형 안에 셀 개수
        int quadrantSize = half * half;

        // 분할된 사각형 4개에 대해 각각 다시 분할
        // 조건문 => 
        if (r < half && c < half) {
            // top-left
            return Z(n - 1, r, c);
        } else if (r < half && c >= half) {
            // top-right
            return quadrantSize + Z(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            // bottom-left
            return 2 * quadrantSize + Z(n - 1, r - half, c);
        } else {
            // bottom-right
            return 3 * quadrantSize + Z(n - 1, r - half, c - half);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(Z(N, r, c));
    }
}
