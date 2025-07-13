package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027_고층건물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[] b = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }
        
        int maxVisible = 0;
        
        for(int i=0; i<n; i++) {
            int count = 0;
            
            for(int j = i-1; j >= 0; j--) {
                if(isVisible(b, i, j)) {
                    count++;
                }
            }
            
            for(int j = i+1; j < n; j++) {
                if(isVisible(b, i, j)) {
                    count++;
                }
            }
            
            maxVisible = Math.max(maxVisible, count);
        }
        
        System.out.println(maxVisible);
    }
    
    private static boolean isVisible(long[] b, int i, int j){
        if(i < j) {
            for(int k = i+1; k < j; k++) {
                if(blocks(b, i, j, k)) {
                    return false;
                }
            }
        } else {
            for(int k = j+1; k < i; k++) {
                if(blocks(b, i, j, k)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean blocks(long[] b, int i, int j, int k){
        double lineHeight = b[i] + (double)(b[j] - b[i]) * (double)(k - i) / (double)(j - i);
        return b[k] >= lineHeight;
    }
}