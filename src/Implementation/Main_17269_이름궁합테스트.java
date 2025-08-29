package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17269_이름궁합테스트 {
    static int[] pre = {
        3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        ArrayList<Integer> list = new ArrayList<>(n + m);
        int max = Math.max(n, m);
        for (int i = 0; i < max; i++) {
            if (i < n) list.add(pre[A.charAt(i) - 'A']);
            if (i < m) list.add(pre[B.charAt(i) - 'A']);
        }

        int len = list.size();
        int[] board = new int[len];
        for (int i = 0; i < len; i++) board[i] = list.get(i);

        for (int k = len; k > 2; k--) {
            for (int i = 0; i < k - 1; i++) {
                board[i] = (board[i] + board[i + 1]) % 10;
            }
        }

        System.out.println((board[0]*10)+(board[1])+"%");
    }
}