package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17305_사탕배달 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        
        List<Integer> three = new ArrayList<>();
        List<Integer> five = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int sweetness = Integer.parseInt(st.nextToken());
            
            if (weight == 3) {
                three.add(sweetness);
            } else {
                five.add(sweetness);
            }
        }
        
        Collections.sort(three, Collections.reverseOrder());
        Collections.sort(five, Collections.reverseOrder());
        
        long[] sumThree = new long[three.size() + 1];
        long[] sumFive = new long[five.size() + 1];
        
        for (int i = 0; i < three.size(); i++) {
            sumThree[i + 1] = sumThree[i] + three.get(i);
        }
        for (int i = 0; i < five.size(); i++) {
            sumFive[i + 1] = sumFive[i] + five.get(i);
        }
        
        int threeMaxCount = Math.min(limit / 3, three.size());
        long maxSugar = 0;

        for (int i = 0; i <= threeMaxCount; i++) {
            int extra = limit - (i * 3);
            int fiveMaxCount = Math.min(extra / 5, five.size());

            long currentSugar = sumThree[i] + sumFive[fiveMaxCount];
            maxSugar = Math.max(maxSugar, currentSugar);
        }
        
        System.out.println(maxSugar);
    }
}