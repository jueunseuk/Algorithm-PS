package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1373_2진수8진수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        if(input.length % 3 == 1) {
        	sb.append(input[0]);
        	idx = 1;
        } else if(input.length % 3 == 2) {
        	sb.append((input[0]-'0')*2+(input[1]-'0'));
        	idx = 2;
        }

        while(idx < input.length) {
        	sb.append((input[idx++]-'0')*4+(input[idx++]-'0')*2+(input[idx++]-'0'));
        }
        
        System.out.println(sb.toString().trim());
	}
}