package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2374_같은수만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Long> st = new Stack<>();
        
        long cnt = 0;
        long max = 0;
        
        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            max = Math.max(max, input);

            if (st.isEmpty()) {
                st.push(input);
            } else {
                if (st.peek() < input) {
                    cnt += input - st.pop();
                    st.push(input);
                } else if (st.peek() > input) {
                    st.pop();
                    st.push(input);
                }
            }
        }
        
        while (!st.isEmpty()) {
            cnt += max - st.pop();
        }
        
        System.out.println(cnt);
    }
}
