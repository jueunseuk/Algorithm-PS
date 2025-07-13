package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_5397_키로거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            
            for (char c : input) {
                switch (c) {
                    case '<':
                        if (!leftStack.isEmpty()) {
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case '>':
                        if (!rightStack.isEmpty()) {
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    case '-':
                        if (!leftStack.isEmpty()) {
                            leftStack.pop();
                        }
                        break;
                    default:
                        leftStack.push(c);
                        break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            while (!leftStack.isEmpty()) {
                result.append(leftStack.pop());
            }
            result.reverse();
            while (!rightStack.isEmpty()) {
                result.append(rightStack.pop());
            }
            
            System.out.println(result.toString());
        }
    }
}
