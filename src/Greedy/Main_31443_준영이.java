package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_31443_준영이 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int rowCnt2, rowCnt1, colCnt2, colCnt1;
        rowCnt2 = r / 2;
        rowCnt1 = 0;
        colCnt2 = c / 2;
        colCnt1 = 0;
        
        if(r % 2 == 1) {
        	rowCnt1++;
        }
        
        if(c % 2 == 1) {
        	colCnt1++;
        }
        
        long happy = 1;
        for(int i = 0; i < rowCnt2; i++) {
        	happy <<= 2;
        	happy %= MOD;
        }
        
        if(r % 2 == 1) {
        	happy <<= 1;
        	happy %= MOD;
        }
        
        for(int i = 0; i < colCnt2; i++) {
        	happy *= happy;
        	happy %= MOD;
        }
        
        if(c % 2 == 1) {
        	for(int i = 0; i < rowCnt2; i++) {
        		happy <<= 1;
        		happy %= MOD;
        	}
        }
        
        System.out.println(happy);
        
    }
}