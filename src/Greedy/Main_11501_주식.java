package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11501_주식 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	
        	int n = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	
        	int stock[] = new int[n];
        	
        	for(int i = 0; i < n; i++) {
        		stock[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	long currentStock = 0;
        	long currentMax = stock[n-1];
        	long account = 0;
        	
        	for(int i = n-2; i >= 0; i--) {
        		if(stock[i] < currentMax) {
        			currentStock++;
        			account -= stock[i];
        		} else {
        			account += currentStock*currentMax;
        			currentMax = stock[i];
        			currentStock = 0;
        		}
        	}
        	
        	System.out.println(account+currentStock*currentMax);
        }
        
	}

}
