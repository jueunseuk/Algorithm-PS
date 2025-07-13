package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13199_치킨먹고싶다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int price = Integer.parseInt(st.nextToken());
            int asset = Integer.parseInt(st.nextToken());
            int need  = Integer.parseInt(st.nextToken());
            int free  = Integer.parseInt(st.nextToken());
            
            int X = asset / price;
            
            int Tcoupon = X * free;
            
            int duFree = Tcoupon / need;
            
            int sangFree = 0;
            if(Tcoupon >= need) {
                sangFree = 1 + (Tcoupon - need) / (need - free);
            }
            
            sb.append(sangFree - duFree).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
}
