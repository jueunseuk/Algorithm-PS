package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24023_아기홍윤 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        boolean found = false;
        
        for (int i = 0; i < N; i++) {
            if ((A[i] & ~K) != 0) {
                if (checkSegment(A, start, i - 1, K)) {
                    found = true;
                    break;
                }
                start = i + 1;
            }
        }
        
        if (!found) {
            if (!checkSegment(A, start, N - 1, K)) {
                System.out.println(-1);
            }
        }
    }
    
    private static boolean checkSegment(int[] A, int start, int end, int K) {
        if (start > end) {
            return false;
        }
        
        int curOr = 0;
        int left = start;
        
        for (int r = start; r <= end; r++) {
            curOr |= A[r];
            if (curOr == K) {
                System.out.println((left + 1) + " " + (r + 1));
                return true;
            }
        }
        
        return false;
    }
}
