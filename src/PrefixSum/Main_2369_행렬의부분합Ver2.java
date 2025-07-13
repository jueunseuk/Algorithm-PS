package PrefixSum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2369_행렬의부분합Ver2 {
    
    static int modAdd(int a, int b, int mod) {
        int sum = a + b;
        sum %= mod;
        
        if(sum < 0) sum += mod;
        
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] matrix = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int FX = X;
        long ans = 0;
        
        int[][] psum = new int[Y+1][FX+1];
        int[] cnt = new int[K];
        
        for (int cx = 0; cx < FX; cx++) {
            int effectiveWidth = FX - cx;
            
            for (int x = 0; x <= effectiveWidth; x++) {
                psum[0][x] = 0;
            }
            for (int y = 0; y < Y; y++) {
                int rowSum = 0;
                psum[y+1][0] = 0;
                
                for (int x = 0; x < effectiveWidth; x++) {
                    rowSum = modAdd(rowSum, matrix[y][x + cx], K);
                    psum[y+1][x+1] = modAdd(psum[y][x+1], rowSum, K);
                }
            }
            
            for (int x = 0; x < effectiveWidth; x++) {
                long tmp = 0;
                ArrayList<Integer> used = new ArrayList<>();
                cnt[0] = 1;
                used.add(0);
                for (int y = 0; y < Y; y++) {
                    int v = psum[y+1][x+1];
                    tmp += cnt[v];
                    cnt[v]++;
                    used.add(v);
                }
                for (int v : used) {
                    cnt[v] = 0;
                }
                ans += tmp;
            }
        }
        
        System.out.println(ans);
    }
}
