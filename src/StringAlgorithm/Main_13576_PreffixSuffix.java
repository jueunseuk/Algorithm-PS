package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_13576_PreffixSuffix {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String S = br.readLine();
    	int n = S.length();

        int[] Z = computeZArray(S);

        List<Integer> borders = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            if(i + Z[i] == n){
                borders.add(n - i);
            }
        }
        
        borders.add(n);

        Collections.sort(borders);

        int[] countOccur = new int[n+1];
        for(int i = 1; i < n; i++) {
            countOccur[Z[i]]++;
        }

        for(int x = n-1; x >= 1; x--) {
            countOccur[x] += countOccur[x+1];
        }

        System.out.println(borders.size());
        
        StringBuilder sb = new StringBuilder();
        for(int L : borders) {
            int c;
            
            if(L == n) {
                c = 1;
            } else {
                c = 1 + countOccur[L];
            }
            
            sb.append(L).append(" ").append(c).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    public static int[] computeZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0;
        
        for(int i = 1; i < n; i++){
            if(i <= R){
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            
            while(i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            
            if(i + Z[i] - 1 > R){
                L = i; 
                R = i + Z[i] - 1;
            }
        }
        
        return Z;
    }
}
