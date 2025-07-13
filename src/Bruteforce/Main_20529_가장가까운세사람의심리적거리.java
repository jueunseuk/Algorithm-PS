package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20529_가장가까운세사람의심리적거리 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	char[][] mbti = new char[n][4];
        	
        	String[] input = br.readLine().split(" ");
        	
        	for(int i = 0; i < n; i++) {
        		mbti[i] = input[i].toCharArray();
        	}
        	
        	if(n > 32) {
        		sb.append(0+"\n");
        		continue;
        	}
        	
        	int min = Integer.MAX_VALUE;
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = i+1; j < n; j++) {
        			for(int k = j+1; k < n; k++) {
        				int result1 = getGap(mbti[i], mbti[j]);
        				int result2 = getGap(mbti[i], mbti[k]);
        				int result3 = getGap(mbti[j], mbti[k]);
        				
        				min = Math.min(min, result1+result2+result3);
        			}
        		}
        	}
        	
        	sb.append(min+"\n");
        }

        System.out.println(sb.toString().trim());
	}
	
	public static int getGap(char[] c1, char[] c2) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			if(c1[i] != c2[i]) {
				cnt++;
			}
		}
		return cnt;
	}

}
