package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1264_모음의개수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	String input = br.readLine();
        	
        	if(input.equals("#")) break;
        	
        	int cnt = 0;
        	for(int i = 0; i < input.length(); i++) {
        		if(set.contains(input.charAt(i))) {
        			cnt++;
        		}
        	}
        	
        	sb.append(cnt+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}