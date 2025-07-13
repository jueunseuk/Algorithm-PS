package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_12933_오리 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        String origin[] = {"q", "u", "a", "c", "k"};
        
        Queue<Character> q = new ArrayDeque<>();
        
        for(int i = 0; i < input.length(); i++) {
        	q.add(input.charAt(i));
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
        	int idx = 0;
        	int size = q.size();
        	while(true) {
        		if(idx == size-1) {
        			break;
        		}
        		
        	}
        	if(q.size() != size)
        	cnt++;
        }
	}

}
