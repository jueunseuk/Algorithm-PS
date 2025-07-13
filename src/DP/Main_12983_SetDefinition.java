package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_12983_SetDefinition {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        int[] queries = new int[T];
        
        int maxN = 0;
        for(int i = 0; i < T; i++){
            queries[i] = Integer.parseInt(br.readLine());
            if(queries[i] > maxN) maxN = queries[i];
        }

        long[] s = new long[maxN+1]; 
        s[1] = 1;
        int i2 = 1, i3 = 1;
        for(int k = 2; k <= maxN; k++){
            long next2 = 2*s[i2] + 1;
            long next3 = 3*s[i3] + 1;
            
            s[k] = Math.min(next2, next3);
            
            if(s[k] == next2) i2++;
            if(s[k] == next3) i3++;
        }

        StringBuilder sb = new StringBuilder();
        for(int q : queries){
            sb.append(s[q]).append("\n");
        }
        System.out.print(sb);
    }
}
