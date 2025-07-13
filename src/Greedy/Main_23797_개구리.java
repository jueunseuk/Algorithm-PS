package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_23797_개구리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        
        int k = 0;
        int p = 0;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == 'K') {
                k++;
                if (p > 0) {
                    p--;
                }
            } else {
                p++;
                if (k > 0) {
                    k--;
                }
            }
        }
        
        System.out.println(k + p);
    }
}
