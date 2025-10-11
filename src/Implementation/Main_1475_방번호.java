package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1475_방번호 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        int cnt[] = new int[10];
        
        for(int i = 0; i < input.length; i++) {
        	cnt[input[i]-'0']++;
        }
        
        if((cnt[6] + cnt[9]) % 2 == 0) {
        	cnt[6] = (cnt[6] + cnt[9]) / 2;
        } else {
        	cnt[6] = (cnt[6] + cnt[9]) / 2 + 1;
        }
        
        int max = 0;
        for(int i = 1; i < 9; i++) {
        	max = Math.max(max, cnt[i]);
        }
        
        System.out.println(max);
	}
}