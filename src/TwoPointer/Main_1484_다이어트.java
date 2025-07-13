package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1484_다이어트 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine());
        boolean found = false;
        
        long left = 1;
        long right = 2;
        
        while(right <= 100000) {
            long diff = right * right - left * left;
            
            if(diff > G) {
                left++;
            } else if(diff < G) {
                right++;
            } else {
                System.out.println(right);
                found = true;
                right++;
            }
        }
        
        if(!found) {
            System.out.println(-1);
        }
    }
}
