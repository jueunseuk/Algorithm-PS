package PrefixSum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020_개똥벌레 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[] countBottom = new int[H+2];
        int[] countTop = new int[H+2];
        
        for(int i = 0; i < N; i++) {
            int high = Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                countBottom[high]++;
            } else {
                countTop[high]++;
            }
        }
        
        for(int i = H; i >= 1; i--) {
            countBottom[i] += countBottom[i+1];
            countTop[i] += countTop[i+1];
        }
        
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        
        for(int i = 1; i <= H; i++) {
            int obstacles = countBottom[i] + countTop[H - i + 1];
            if(obstacles < min) {
                min = obstacles;
                cnt = 1;
            } else if(obstacles == min) {
                cnt++;
            }
        }
        
        System.out.println(min + " " + cnt);
    }
}
