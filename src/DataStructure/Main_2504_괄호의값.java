package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split("");
        
        Stack<String> st = new Stack<>();
        
        for(int i = 0; i < input.length; i++) {
        	switch(input[i]) {
	        	case "(":{
	        		st.add("(");
	        		break;
	        	}
	        	case ")":{
	        		int temp = 0;
	        		while(!st.isEmpty() && !st.peek().equals("(")) {
	        			try {
	        				temp += Integer.parseInt(st.pop());
						} catch (NumberFormatException e) {
							System.out.println(0);
							return;
						}
	        		}
	        		if(st.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
	        		st.pop();
	        		if(temp == 0) {
	        			st.add("2");
	        		} else {
	        			st.add(String.valueOf(temp*2));
	        		}
	        		break;
	        	}
	        	case "[":{
	        		st.add("[");
	        		break;
	        	}
	        	case "]":{
	        		int temp = 0;
	        		while(!st.isEmpty() && !st.peek().equals("[")) {
	        			try {
	        				temp += Integer.parseInt(st.pop());
						} catch (NumberFormatException e) {
							System.out.println(0);
							return;
						}
	        		}
	        		if(st.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
	        		st.pop();
	        		if(temp == 0) {
	        			st.add("3");
	        		} else {
	        			st.add(String.valueOf(temp*3));
	        		}
	        		break;
	        	}
        	}
        }
        
        for(String s : st) {
            if(s.equals("(") || s.equals("[")) {
                System.out.println(0);
                return;
            }
        }
        
        int result = 0;
        for(String out : st) {
        	result += Integer.parseInt(out);
        }
        System.out.println(result);

	}
}
