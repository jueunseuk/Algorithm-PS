package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1474_밑줄 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] input = new String[n];
        
        int strL = 0;
        
        for(int i = 0; i < n; i++) {
        	input[i] = br.readLine();
        	strL += input[i].length();
        }
        
        int targetL = m - strL;
        
        int divide = targetL/(n-1);
        int remain = targetL%(n-1);
        
        int under[] = new int[n-1];
        Arrays.fill(under, divide);
        
        for(int i = 0; i < remain; i++) {
        	under[i]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n-1; i++) {
        	sb.append(input[i]);
        	for(int j = 0; j < under[i]; j++) {
        		sb.append("_");
        	}
        }
        
        System.out.println(sb.append(input[n-1]).toString().trim());
        
	}

}
