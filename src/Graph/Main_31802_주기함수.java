package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31802_주기함수 {
    static long[] getQuotAndRem(long x, long n) {
        long r = (x % n + n) % n; 
        long q = (x - r) / n;
        return new long[] {q, r};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cycle = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            cycle[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] prefix = new long[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + cycle[i];
        }
        long periodSum = prefix[n];

        st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end   = Long.parseLong(st.nextToken());
        
        if(start > end) {
            long tmp = start;
            start = end;
            end   = tmp;
        }

        if(start == end) {
            System.out.println(0);
            return;
        }

        long[] A = getQuotAndRem(start, n);
        long[] B = getQuotAndRem(end, n);
        long qa = A[0], ra = A[1];
        long qb = B[0], rb = B[1];

        if(qa == qb) {
            System.out.println(prefix[(int)rb] - prefix[(int)ra]);
            return;
        }
        
        long left = prefix[n] - prefix[(int)ra];
        long right = prefix[(int)rb];
        long midCount = (qb - qa - 1);
        if(midCount < 0) midCount = 0;

        long result = left + right + midCount * periodSum;
        System.out.println(result);
    }
}
