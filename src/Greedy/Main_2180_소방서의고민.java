package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2180_소방서의고민 {
	static final int MOD = 40000;

	public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] input = new int[n][2];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	input[i][0] = Integer.parseInt(st.nextToken());
        	input[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long a1 = o1[0], b1 = o1[1];
                long a2 = o2[0], b2 = o2[1];

                if(a1 == 0 && a2 == 0) {
                    return 0;
                }
                if(a1 == 0 && a2 != 0) {
                    return 1;
                }
                if(a1 != 0 && a2 == 0) {
                    return -1;
                }

                long left = b1 * a2;
                long right = b2 * a1;
                return Long.compare(left, right);
            }
        });
        
        int curr = 0;
        for(int i = 0; i < n; i++) {
        	curr = (curr + (input[i][0]*curr+input[i][1]) % MOD) % MOD;
        }
        
        System.out.println(curr);
	}

}
