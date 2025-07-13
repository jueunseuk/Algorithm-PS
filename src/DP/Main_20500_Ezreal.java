package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20500_Ezreal {
	
    static final long MOD = 1000000007;
    static long[] fac, inv;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if(N == 1){
            System.out.println(0);
            return;
        }
        
        fac = new long[N];
        inv = new long[N];
        
        fac[0] = 1;
        for(int i = 1; i < N; i++){
            fac[i] = fac[i-1]*i%MOD;
        }
        
        inv[N-1] = pow(fac[N-1],MOD-2);
        for(int i = N-2; i >= 0; i--){
            inv[i] = inv[i+1]*(i+1)%MOD;
        }
        
        long ans = 0; 
        
        int r = (2*N)%3; 
        for(int x = r; x <= N-1; x+=3){
            ans = (ans + comb(N-1,x))%MOD;
        }
        
        System.out.println(ans);
    }
    
    static long comb(int n,int r){
        if(r < 0 || r > n)return 0;
        
        return fac[n] * inv[r] % MOD * inv[n-r] % MOD;
    }
    static long pow(long base,long exp){
        long result=1;
        
        while(exp > 0){
            if((exp&1)==1) result = result * base % MOD;
            base = base * base % MOD; exp >>= 1;
        }
        
        return result;
    }
}
