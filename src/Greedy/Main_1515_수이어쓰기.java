package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1515_수이어쓰기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();

        int idx = 0;
        for(int i = 1; ; i++) {
            String target = String.valueOf(i);
            for(int k = 0; k < target.length(); k++) {
                if(idx < s.length() && target.charAt(k) == s.charAt(idx)) {
                    idx++;
                    if(idx == s.length()) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}