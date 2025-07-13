package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21600_계단 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int answer = 0;
        int curr;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            curr = Integer.parseInt(st.nextToken());
            
            if (cnt + 1 <= curr) {
                cnt++;
                answer = Math.max(answer, cnt);
            } else {
                cnt = curr;
            }
        }
        
        System.out.println(answer);
    }
}
