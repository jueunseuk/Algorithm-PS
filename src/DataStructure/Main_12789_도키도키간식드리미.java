package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_12789_도키도키간식드리미 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        int want = 1;

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() == want) {
                stack.pop();
                want++;
            }
            
            if(x == want) {
                want++;
            } else {
                stack.push(x);
            }
        }

        while(!stack.isEmpty() && stack.peek() == want) {
            stack.pop();
            want++;
        }

        System.out.println(want == n + 1 ? "Nice" : "Sad");
    }
}