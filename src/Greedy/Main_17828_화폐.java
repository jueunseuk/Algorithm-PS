package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17828_화폐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int length = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (length * 26 < target || length > target) {
            System.out.println("!");
            return;
        }

        int[] result = new int[length];

        target -= length;

        for (int idx = length - 1; idx >= 0 && target > 0; idx--) {
            if (target >= 25) { 
                result[idx] += 25;
                target -= 25;     
            } else { 
                result[idx] += target;
                target = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append((char) (value + 65));
        }
        
        System.out.println(sb.toString());
    }
}
