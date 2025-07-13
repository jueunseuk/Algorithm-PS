package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        while (true) {
            input = br.readLine();
            
            if (input.equals(".")) {
                break;
            }
            
            if (isBalanced(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
