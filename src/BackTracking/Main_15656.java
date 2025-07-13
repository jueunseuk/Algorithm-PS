package BackTracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656 {
    static int N, R;
    static int[] input;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(input);
        
        result = new int[R];
        
        recursive(0);
        bw.flush(); // 모든 출력을 끝낸 후 한 번에 출력
        bw.close();
    }
    
    private static void recursive(int depth) throws IOException {
        if(depth == R) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < R; i++) {
                sb.append(result[i]);
                if(i < R - 1) sb.append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++) {
            result[depth] = input[i];
            recursive(depth+1);
        }
    }
}
