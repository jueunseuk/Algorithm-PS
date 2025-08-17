package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12764_싸지방에간준하 {
    static class Use {
        int end, seat;
        Use(int end, int seat) { this.end = end; this.seat = seat; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][2];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        PriorityQueue<Use> using = new PriorityQueue<>((u1, u2) -> u1.end - u2.end);
        PriorityQueue<Integer> idle = new PriorityQueue<>();

        int maxSeat = 0;
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int s = a[i][0], e = a[i][1];

            while (!using.isEmpty() && using.peek().end <= s) {
                idle.offer(using.poll().seat);
            }

            int seat;
            if (idle.isEmpty()) seat = ++maxSeat;
            else seat = idle.poll();

            cnt[seat]++;
            using.offer(new Use(e, seat));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxSeat+"\n");
        for (int i = 1; i <= maxSeat; i++) {
        	sb.append(cnt[i]).append(' ');
        }
        
        System.out.println(sb.toString().trim());
    }
}
