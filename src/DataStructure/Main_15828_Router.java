package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_15828_Router {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        
        while(true) {
        	int input = Integer.parseInt(br.readLine());
        	
        	if(input == -1) {
        		break;
        	}
        	
        	if(input == 0) {
        		q.poll();
        		continue;
        	}
        	
        	if(q.size() < size) {
        		q.offer(input);
        	}
        }

        int l = q.size();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < l; i++) {
        	sb.append(q.poll()+" ");
        }
        
        System.out.println(l == 0 ? "empty" : sb.toString().trim());
	}
}