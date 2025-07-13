package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int city = Integer.parseInt(br.readLine());
		
		long []distance = new long[city-1];
		long []cost = new long[city-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < city -1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < city-1; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		br.close();
		
		long minCost = Long.MAX_VALUE;
		long result = 0;
		for(int i = 0; i < city - 1; i++) {
			minCost = Math.min(minCost, cost[i]);
			
			result += distance[i]*minCost;
		}
		
		System.out.println(result);
	}

}
