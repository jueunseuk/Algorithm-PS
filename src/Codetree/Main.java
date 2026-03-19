package Codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        input[1] = 'a';
        input[input.length-2] = 'a';
        
        StringBuilder sb = new StringBuilder();
        for(char c : input) {
        		sb.append(c);
        }
        
        System.out.println(sb.toString());
	}
}