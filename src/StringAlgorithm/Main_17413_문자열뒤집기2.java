package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_문자열뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < arr.length) {
            if (arr[i] == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                while (i < arr.length && arr[i] != '>') sb.append(arr[i++]);
                sb.append(arr[i++]);
            } else if (arr[i] == ' ') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
                i++;
            } else {
                stack.push(arr[i++]);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.print(sb.toString());
    }
}
