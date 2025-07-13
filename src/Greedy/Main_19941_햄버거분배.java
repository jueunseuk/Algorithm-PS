package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19941_햄버거분배 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        char[] c = br.readLine().toCharArray();
        boolean check[] = new boolean[n+1];
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
        	if(c[i] == 'H') continue;
        	int idx = i-k;
        	
        	if(idx < 0) idx = 0;
        	
        	while(idx <= i+k) {
        		if(!check[idx] && c[idx] == 'H') {
        			cnt++;
        			check[idx] = true;
        			break;
        		} else {
        			idx++;
        			if(idx >= n) break;
        		}
        	}
        }
        
        System.out.println(cnt);
	}
}