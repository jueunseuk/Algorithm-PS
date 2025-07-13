package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1213_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] origin = br.readLine().toCharArray();
        int[] cnt = new int[26];
        
        for(int i = 0; i < origin.length; i++) {
        	cnt[origin[i]-'A']++;
        }
        
        int odd = 0;
        for(int i = 0; i < 26; i++) {
        	if(cnt[i] % 2 == 1) {
        		odd++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        if(odd > 1) {
        	System.out.println("I'm Sorry Hansoo");
        	return;
        } else if( odd == 1) {
        	for(int i = 0; i < 26; i++) {
        		for(int j = 0; j < cnt[i]/2; j++) {
        			sb.append((char) ('A'+i));
        		}
        	}
        	
        	char mid = 'A';
        	for(int i = 0; i < 26; i++) {
        		if(cnt[i] % 2== 1) {
        			mid = (char) ('A' + i);
        		}
        	}
        	
        	System.out.println(sb.toString()+mid+sb.reverse().toString());
        } else {
        	for(int i = 0; i < 26; i++) {
        		for(int j = 0; j < cnt[i]/2; j++) {
        			sb.append((char) ('A'+i));
        		}
        	}
        	
        	System.out.println(sb.toString()+sb.reverse().toString());
        }
	}
}