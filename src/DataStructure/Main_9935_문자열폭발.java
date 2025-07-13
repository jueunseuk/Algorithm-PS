package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        int inputLength = input.length;
        int targetLength = target.length;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < inputLength; i++) {
        	stack.push(input[i]);
        	
        	if(stack.size() >= targetLength) {
        		int size = stack.size();
        		
        		for(int j = 0; j < targetLength; j++) {
        			if(target[j] == stack.get(size-targetLength+j)) {
        				if(j == targetLength-1) for(int k = 0; k < targetLength; k++) stack.pop();
        			} else {
        				break;
        			}
        		}
        	}
        }
        
        if(stack.isEmpty()) {
        	System.out.println("FRULA");
        } else {
        	StringBuilder sb = new StringBuilder();
        	for(char out : stack) {
        		sb.append(out);
        	}
        	System.out.println(sb.toString().trim());
        }
        
    }
}
