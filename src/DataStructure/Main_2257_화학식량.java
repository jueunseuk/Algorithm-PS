package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2257_화학식량 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < input.length; i++) {
        	switch(input[i]) {
	        	case '(':{
	        		st.add(0);
	        		break;
	        	}
	        	case ')':{
	        		int temp = 0;
	        		while(!st.isEmpty() && st.peek() != 0) {
	        			temp += st.pop();
	        		}
	        		st.pop();
	        		st.add(temp);
	        		break;
	        	}
	        	case 'C':{
	        		st.add(12);
	        		break;
	        	}
	        	case 'O':{
	        		st.add(16);
	        		break;
	        	}
	        	case 'H':{
	        		st.add(1);
	        		break;
	        	}
	        	default:{
	        		if(!st.isEmpty()) {
	        			st.add(st.pop()*(input[i]-'0'));
	        		}
	        		break;
	        	}
        	}
        }
        
        int result = 0;
        for(int out : st) {
        	result += out;
        }
        System.out.println(result);

	}

}
