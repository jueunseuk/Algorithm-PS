package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2506_점수계산 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int curr = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
        		if(Integer.parseInt(st.nextToken()) == 1) {
        			sum += curr++;
        		} else {
        			curr = 1;
        		}
        }
        
        System.out.println(sum);
	}
}