package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2778_측량사지윤 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long[][] L = new long[3][3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    L[i][j] = Long.parseLong(st.nextToken());
                }
            }

            if (det(L[0], L[1]) == 0 || det(L[0], L[2]) == 0 || det(L[1], L[2]) == 0) {
                sb.append("0.0000\n");
                continue;
            }

            double[] p1 = intersect(L[0], L[1]);
            double[] p2 = intersect(L[0], L[2]);
            double[] p3 = intersect(L[1], L[2]);

            double cross = (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p3[0] - p1[0]) * (p2[1] - p1[1]);
            double area = Math.abs(cross) / 2.0;

            sb.append(String.format("%.4f", area)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static long det(long[] l1, long[] l2) {
        return l1[0] * l2[1] - l2[0] * l1[1];
    }

    static double[] intersect(long[] l1, long[] l2) {
        long a1 = l1[0], b1 = l1[1], c1 = l1[2];
        long a2 = l2[0], b2 = l2[1], c2 = l2[2];

        long D = a1 * b2 - a2 * b1;

        double x = (double)(b1 * c2 - b2 * c1) / (double)D;
        double y = (double)(a2 * c1 - a1 * c2) / (double)D;

        return new double[]{x, y};
    }
}
