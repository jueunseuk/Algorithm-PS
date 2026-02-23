package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25682_체스판다시칠하기2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[][] misB = new int[row + 1][col + 1];
        int[][] misW = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= col; j++) {
                char cur = input[j - 1];

                char expectB = ((i + j) % 2 == 0) ? 'B' : 'W';
                if (cur != expectB) misB[i][j] = 1;

                char expectW = ((i + j) % 2 == 0) ? 'W' : 'B';
                if (cur != expectW) misW[i][j] = 1;
            }
        }

        int[][] bSum = new int[row + 1][col + 1];
        int[][] wSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                bSum[i][j] = misB[i][j] + bSum[i - 1][j] + bSum[i][j - 1] - bSum[i - 1][j - 1];
                wSum[i][j] = misW[i][j] + wSum[i - 1][j] + wSum[i][j - 1] - wSum[i - 1][j - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i + size - 1 <= row; i++) {
            for (int j = 1; j + size - 1 <= col; j++) {
                int x2 = i + size - 1;
                int y2 = j + size - 1;

                int repaintB = bSum[x2][y2] - bSum[i - 1][y2] - bSum[x2][j - 1] + bSum[i - 1][j - 1];
                int repaintW = wSum[x2][y2] - wSum[i - 1][y2] - wSum[x2][j - 1] + wSum[i - 1][j - 1];

                min = Math.min(min, Math.min(repaintB, repaintW));
            }
        }

        System.out.println(min);
    }
}