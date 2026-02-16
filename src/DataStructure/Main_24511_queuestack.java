package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24511_queuestack {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] v = new int[n];
        for(int i = 0; i < n; i++) {
        	v[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = n-1; i >= 0; i--) {
        	if(arr[i] == 0 && cnt < m) {
        		cnt++;
        		sb.append(v[i]).append(" ");
        	}
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m-cnt; i++) {
        	sb.append(Integer.parseInt(st.nextToken())).append(" ");
        }
        
        System.out.println(sb.toString().trim());
	}
}