package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1700_멀티탭스케줄링 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] schedule = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }
        
        Set<Integer> multiTap = new HashSet<>();
        
        int cnt = 0;
        
        for (int i = 0; i < K; i++) {
            int curr = schedule[i];
            
            if (multiTap.contains(curr)) {
                continue;
            }
            
            if (multiTap.size() < N) {
                multiTap.add(curr);
                continue;
            }
            
            cnt++;
            
            int app = -1;
            int far = -1;
            
            for (int plugged : multiTap) {
                int next = -1;
                for (int j = i + 1; j < K; j++) {
                    if (schedule[j] == plugged) {
                    	next = j;
                        break;
                    }
                }
                
                if (next == -1) {
                	app = plugged;
                    break;
                } else if (next > far) {
                	far = next;
                    app = plugged;
                }
            }
            
            multiTap.remove(app);
            multiTap.add(curr);
        }
        
        System.out.println(cnt);
    }
}