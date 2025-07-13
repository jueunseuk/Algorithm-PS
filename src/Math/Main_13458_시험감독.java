package Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] input = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int admin = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        
        long cnt = 0;
        for(int i = 0; i < n; i++) {
        	if(input[i] <= admin) {
        		cnt++;
        	} else {
        		cnt++;
        		input[i] -= admin;
        		
        		if(input[i] % sub == 0) {
        			cnt += input[i] / sub;
        		} else {
        			cnt += input[i] / sub;
        			cnt++;
        		}
        	}
        }
        
        System.out.println(cnt);
	}
}
