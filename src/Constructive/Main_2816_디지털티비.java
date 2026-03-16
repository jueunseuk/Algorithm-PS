package Constructive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2816_디지털티비 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int kbs1 = -1;
        int kbs2 = -1;
        
        for(int i = 0; i < n; i++) {
        	String input = br.readLine();
        	if(input.equals("KBS1")) kbs1 = i+1;
        	else if(input.equals("KBS2")) kbs2 = i+1;
        }
        
        if(kbs2 < kbs1) kbs2++;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < kbs1; i++) {
        	sb.append(1);
        }
        for(int i = 1; i < kbs1; i++) {
        	sb.append(4);
        }
        
        if(kbs2 == 2) {
        	System.out.println(sb.toString().trim());
        	return;
        }
        
        sb.append(1);
        for(int i = 2; i < kbs2; i++) {
        	sb.append(1);
        }
        for(int i = 2; i < kbs2; i++) {
        	sb.append(4);
        }
        
        System.out.println(sb.toString().trim());
	}
}