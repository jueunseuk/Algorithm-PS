package GameTheory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11694_님게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long nimSum = 0;
        long[] piles = new long[n];
        boolean check = true;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            piles[i] = Long.parseLong(st.nextToken());
            
            if(piles[i] != 1) {
            	check = false;
            }
            
            nimSum ^= piles[i];
        }
        
        if (check) {
            if(n % 2 == 1) System.out.println("cubelover");
            else System.out.println("koosaga");
        } else {
            if (nimSum != 0) System.out.println("koosaga");
            else System.out.println("cubelover");
        }
    }
}
