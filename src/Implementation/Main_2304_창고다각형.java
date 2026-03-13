package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2304_창고다각형 {
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[SIZE + 1];

        int maxH = 0;
        int maxIdx = 0;
        int minIdx = SIZE;
        int lastIdx = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[l] = h;

            if (h > maxH) {
                maxH = h;
                maxIdx = l;
            }

            minIdx = Math.min(minIdx, l);
            lastIdx = Math.max(lastIdx, l);
        }

        int sum = 0;

        // 왼쪽 -> 최고 기둥
        int leftMax = 0;
        for (int i = minIdx; i < maxIdx; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            sum += leftMax;
        }

        // 최고 기둥
        sum += maxH;

        // 오른쪽 -> 최고 기둥
        int rightMax = 0;
        for (int i = lastIdx; i > maxIdx; i--) {
            rightMax = Math.max(rightMax, arr[i]);
            sum += rightMax;
        }

        System.out.println(sum);
    }
}