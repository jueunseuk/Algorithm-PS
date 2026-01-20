package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2864_5와6의차이 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        char[] a = input[0].toCharArray();
        char[] b = input[1].toCharArray();
        
        char[] minA = new char[a.length];
        char[] maxA = new char[a.length];
        char[] minB = new char[b.length];
        char[] maxB = new char[b.length];
        
        for(int i = 0; i < a.length; i++) {
        	if(a[i] == '5' || a[i] == '6') {
        		maxA[i] = '6';
        		minA[i] = '5';
        	} else {
        		minA[i] = a[i];
        		maxA[i] = a[i];
        	}
        }
        
        for(int i = 0; i < b.length; i++) {
        	if(b[i] == '5' || b[i] == '6') {
        		maxB[i] = '6';
        		minB[i] = '5';
        	} else {
        		minB[i] = b[i];
        		maxB[i] = b[i];
        	}
        }

        int minAToNum = 0;
        int maxAToNum = 0;
        int minBToNum = 0;
        int maxBToNum = 0;
        
        for(int i = a.length-1; i >= 0; i--) {
        	minAToNum += Math.pow(10, i) * (minA[a.length-i-1] - '0');
        	maxAToNum += Math.pow(10, i) * (maxA[a.length-i-1] - '0');
        }
        
        for(int i = a.length-1; i >= 0; i--) {
        	minBToNum += Math.pow(10, i) * (minB[b.length-i-1] - '0');
        	maxBToNum += Math.pow(10, i) * (maxB[b.length-i-1] - '0');
        }
        
        System.out.println((minAToNum+minBToNum)+" "+(maxAToNum+maxBToNum));
	}
}