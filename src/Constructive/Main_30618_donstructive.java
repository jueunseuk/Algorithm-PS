package Constructive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_30618_donstructive {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = n; i >= 1; i--) {
			if(i % 2 == 0) {
				dq.offerFirst(i);
			} else {
				dq.offerLast(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(' ');
		}
		
		System.out.println(sb.toString().trim());
	}
}