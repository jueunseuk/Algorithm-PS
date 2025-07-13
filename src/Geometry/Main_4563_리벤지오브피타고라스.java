package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4563_리벤지오브피타고라스 {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            long a = Long.parseLong(br.readLine());
            if (a == 0) break;

            long a2 = a * a;
            long count = 0;

            for (long d = 1; d < a; d++) {
                if (a2 % d != 0) continue;
                long e = a2 / d;

                if (((d + e) & 1) != 0) continue; 
                
                if (e - d > 2 * a) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }
        br.close();
        
        System.out.println(sb.toString().trim());
    }
}
