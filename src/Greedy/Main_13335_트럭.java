package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 총 트럭 수
        int l = Integer.parseInt(st.nextToken()); // 다리 길이
        int limit = Integer.parseInt(st.nextToken()); // 다리의 중량 제한
        
        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> trucks = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }
        
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;

        while (!bridge.isEmpty()) {
            time++;
            
            currentWeight -= bridge.poll();
            
            if (!trucks.isEmpty()) {
                if (currentWeight + trucks.peek() <= limit) {
                    int truck = trucks.poll();
                    bridge.add(truck);
                    currentWeight += truck;
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
