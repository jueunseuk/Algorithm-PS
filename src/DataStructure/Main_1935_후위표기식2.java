package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] oper = new int[26];
        
        char[] input = br.readLine().toCharArray();
        
        for(int i = 0; i < n; i++) {
        	oper[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
        	switch(input[i]) {
        		case '+' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b+a);
        			break;
        		}
        		case '-' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b-a);
        			break;
        		}
        		case '*' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b*a);
        			break;
        		}
        		case '/' : {
        			double a = stack.pop();
        			double b = stack.pop();
        			stack.push(b/a);
        			break;
        		}
        		default : {
        			stack.push((double) oper[input[i]-'A']);
        		}
        	}
        }
        
        System.out.printf("%.2f", stack.pop());
	}
}