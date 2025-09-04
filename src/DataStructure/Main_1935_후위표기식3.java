// for blog
package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935_후위표기식3 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = br.readLine().toCharArray();
        
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
        	switch(input[i]) {
        		case '+' : {
        			stack.push(stack.pop()+stack.pop());
        			break;
        		}
        		case '-' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b-a);
        			break;
        		}
        		case '*' : {
        			stack.push(stack.pop()*stack.pop());
        			break;
        		}
        		case '/' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b/a);
        			break;
        		}
        		default : {
        			stack.push((double) (input[i]-'0'));
        		}
        	}
        }
        
        System.out.printf("%.2f", stack.pop());
	}
}