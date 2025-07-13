package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int leng = input.length();
        int cnt1 = 0; 
        int cnt0 = 0;
        
        for(int i = 0; i < leng - 1; i++) {
            if(input.charAt(i) != input.charAt(i + 1)) {
                if(input.charAt(i) == '1') cnt1++;
                else if(input.charAt(i) == '0') cnt0++;
            }
        }

        if (input.charAt(leng - 1) == '1') cnt1++;
        else cnt0++;
        
        System.out.println(Math.min(cnt1, cnt0));
    }
}
