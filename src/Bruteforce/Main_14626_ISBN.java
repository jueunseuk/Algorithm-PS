package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14626_ISBN {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        int[] isbn = new int[13];
        for(int i = 0; i < 13; i++) {
        	if(input[i] == '*') isbn[i] = -1;
        	else isbn[i] = input[i] - '0';
        }
        
        int x = 0;
        int sum = 0;
        for(int i = 0; i < 13; i++) {
        	if(isbn[i] == -1) {
        		x = i;
        		continue;
        	}
        	if(i % 2 == 1) {
        		sum += isbn[i]*3;
        	} else {
        		sum += isbn[i];
        	}
        }
        
        for(int i = 0; i <= 9; i++) {
        	if(x % 2 == 1) {
        		if((sum+i*3)%10 == 0) {
        			System.out.println(i);
        			return;
        		}
        	} else {
        		if((sum+i)%10 == 0) {
        			System.out.println(i);
        			return;
        		}
        	}
        }
	}

}
