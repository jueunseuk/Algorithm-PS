package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int set = Integer.MAX_VALUE, each = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	set = Math.min(set, Integer.parseInt(st.nextToken()));
        	each = Math.min(each, Integer.parseInt(st.nextToken()));
        }
        
        int result = 0;
        if(n >= 6) {
        	if(set > each*6) {
        		result += each*n;
        	} else {
        		result += set*(n/6);
        		n %= 6;
        		if(set > each*n) {
        			result += each*n;
        		} else {
        			result += set;
        		}
        	}
        	System.out.println(result);
        } else {
        	result = Math.min(each*n, set);
        	System.out.println(result);
        }
	}

}
