package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19539_사과나무 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int high[] = new int[n];
        
        int sum = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	high[i] = Integer.parseInt(st.nextToken());
        	sum += high[i];
        	high[i] %= 3;
        	if(high[i] == 1) {
        		cnt1++;
        	} else if(high[i] == 2) {
        		cnt2++;
        	}
        }
        
        if(sum % 3 != 0) {
        	System.out.println("NO");
        	return;
        }
        
        if(cnt1 == cnt2) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
        
	}

}
