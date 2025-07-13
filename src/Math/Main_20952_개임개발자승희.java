package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20952_개임개발자승희 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] A = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        long[] B = new long[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            B[i] = Long.parseLong(st.nextToken());
        }

        boolean[] alive = new boolean[N];
        Arrays.fill(alive, true);

        ArrayDeque<Integer>[] queues = new ArrayDeque[7];
        for(int r=0; r<7; r++){
            queues[r] = new ArrayDeque<>();
        }

        for(int i=0; i<N; i++){
            int r = (int)(A[i] % 7);
            if(r<0) r += 7;
            queues[r].add(i);
        }

        long offset7 = 0;
        long offsetLarge = 0;
        int totalAlive = N;

        for(int i=0; i<M; i++){
            long b = B[i];
            long b7 = b % 7;
            int killClass = (int)((7 - ((offset7 + b7) % 7)) % 7);
            int killCount = queues[killClass].size();

            if(killCount == totalAlive){
                continue;
            }

            offset7 = (offset7 + b7) % 7;
            offsetLarge = (offsetLarge + b) % MOD;

            while(!queues[killClass].isEmpty()){
                int idx = queues[killClass].poll();
                if(alive[idx]){
                    alive[idx] = false;
                    totalAlive--;
                }
            }
        }

        System.out.println(totalAlive);

        if(totalAlive > 0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                if(alive[i]){
                    long val = (A[i] + offsetLarge) % MOD;
                    sb.append(val).append(' ');
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
