package StringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9996_한국이그리울땐서에접속하지 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\*");
        
        int sumL = str[0].length() + str[1].length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	String input = br.readLine();
        	
        	if(input.length() < sumL) {
        		sb.append("NE\n");
        		continue;
        	}
        	
        	if(input.startsWith(str[0]) && input.endsWith(str[1])) {
        		sb.append("DA\n");
        	} else {
        		sb.append("NE\n");
        	}
        }

        System.out.println(sb.toString().trim());
	}
}