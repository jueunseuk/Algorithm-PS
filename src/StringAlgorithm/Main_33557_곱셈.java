package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_33557_곱셈 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	char[] a = st.nextToken().toCharArray();
        	char[] b = st.nextToken().toCharArray();
        	
        	long numa = 0, numb = 0;
        	for(int i = 0; i < a.length; i++) {
        		numa += (a[i] - '0') * Math.pow(10, a.length-i-1);
        	}
        	for(int i = 0; i < b.length; i++) {
        		numb += (b[i] - '0') * Math.pow(10, b.length-i-1);
        	}
        	
        	long corr = numa * numb;
        	
        	StringBuilder sb = new StringBuilder();
        	if(a.length > b.length) {
        		int sub = a.length-b.length;
        		for(int i = 0; i < a.length; i++) {
        			if(i < sub) {
        				sb.append(a[i] - '0');
        			} else {
        				sb.append((a[i] - '0') * (b[i-sub] - '0'));
        			}
        		}
        	} else if(a.length < b.length) {
        		int sub = b.length-a.length;
        		for(int i = 0; i < b.length; i++) {
        			if(i < sub) {
        				sb.append(b[i] - '0');
        			} else {
        				sb.append((a[i-sub] - '0') * (b[i] - '0'));
        			}
        		}
        	} else {
        		for(int i = 0; i < a.length; i++) {
        			sb.append((a[i] - '0') * (b[i] - '0'));
        		}
        	}
        	
        	result.append(Long.parseLong(sb.toString()) == corr ? 1 : 0).append("\n");
        }
        
        System.out.println(result.toString().trim());
	}

}
