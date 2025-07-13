package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2002_추월 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> enterRank = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            enterRank.put(name, i);
        }

        String[] exit = new String[n];
        for (int i = 0; i < n; i++) {
            exit[i] = br.readLine();
        }

        boolean[] isOvertaken = new boolean[n+1]; 
        
        int minEnter = Integer.MAX_VALUE;
        
        for(int i = n - 1; i >= 0; i--) {
            int currEnter = enterRank.get(exit[i]);
            
            if(currEnter > minEnter) {
                isOvertaken[currEnter] = true;
            }
            
            if(currEnter < minEnter) {
                minEnter = currEnter;
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isOvertaken[i]) answer++;
        }

        System.out.println(answer);
    }
}
