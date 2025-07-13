package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9869_MilkScheduling {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] schedule = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
        	schedule[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int milk = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            schedule[time].add(milk);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int result = 0;

        for (int day = 10000; day > 0; day--) {
            for (int score : schedule[day]) {
                pq.offer(score);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
