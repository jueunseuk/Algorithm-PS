package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6828_FromPrefixtoPostfix {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	String[] tokens = br.readLine().split(" ");
        	
        	if(tokens.length == 1 && tokens[0].equals("0")) break;
        	
            Stack<String> stack = new Stack<>();

            for(int i = tokens.length - 1; i >= 0; i--) {
                String tk = tokens[i];

                if(isOperator(tk)) {
                    String left  = stack.pop();
                    String right = stack.pop();
                    stack.push(left + " " + right + " " + tk);
                } else {
                    stack.push(tk);
                }
            }

            sb.append(stack.pop()).append('\n');
        }

        System.out.print(sb.toString());
	}
	
	private static boolean isOperator(String s) {
        return "+-*/".indexOf(s.charAt(0)) >= 0;
    }
}