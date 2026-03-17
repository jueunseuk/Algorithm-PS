package Constructive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_31229_또수열문제야 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> list = new ArrayList<>();
        
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        		sb.append(i*i).append(" ");
        }
        
        System.out.println(sb.toString().trim());
	}
}