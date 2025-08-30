package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_23254_나는기말고사형인간이야 {
    static class Subject {
        int score;
        final int b;

        Subject(int score, int b) {
            this.score = score;
            this.b = b;
        }

        int currGain() {
            return Math.min(b, 100 - score);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hours = Integer.parseInt(st.nextToken()) * 24;
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[M];
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) b[i] = Integer.parseInt(st.nextToken());

        PriorityQueue<Subject> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y.currGain(), x.currGain())
        );

        int total = 0;
        for (int i = 0; i < M; i++) {
            int base = Math.min(100, a[i]);
            total += base;
            if (base < 100 && b[i] > 0) {
                Subject s = new Subject(base, b[i]);
                if (s.currGain() > 0) pq.offer(s);
            }
        }

        while (hours > 0 && !pq.isEmpty()) {
            Subject s = pq.poll();
            int gain = s.currGain();
            if (gain <= 0) break;
            s.score += gain;
            total += gain;
            hours--;

            if (s.score < 100 && s.currGain() > 0) pq.offer(s);
        }

        System.out.println(total);
    }
}
