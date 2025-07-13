package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1092_배 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cranes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes);

        int m = Integer.parseInt(br.readLine());
        int[] boxes = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(boxes);

        if (boxes[m - 1] > cranes[n - 1]) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        boolean[] moved = new boolean[m];
        int movedCount = 0;

        while (movedCount < m) {
            int craneIdx = n - 1;

            for (int i = m - 1; i >= 0; i--) {
                if (craneIdx < 0) break;
                if (!moved[i] && cranes[craneIdx] >= boxes[i]) { 
                    moved[i] = true;
                    movedCount++;
                    craneIdx--;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
