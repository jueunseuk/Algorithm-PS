package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2258_정육점 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		Meat[] meats = new Meat[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			meats[i] = new Meat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meats, new Comparator<Meat>() {
			@Override
			public int compare(Meat o1, Meat o2) {
				if(o1.price == o2.price) {
					return o2.weight - o1.weight;
				}
				return o1.price - o2.price;
			}
		});
		
		long accW = 0;
		long result = Long.MAX_VALUE;
		long answer = Long.MAX_VALUE;
		int prevPrice = 0;
		
		for(Meat out : meats) {
			int currentWeight = out.weight;
			int currentPrice = out.price;
			
			if(currentPrice == prevPrice) {
				result += currentPrice;
			} else {
				result = currentPrice;
			}
			
			accW += currentWeight;
			prevPrice = currentPrice;
			
			if(accW >= target) {
				answer = Math.min(answer, result);
			}
		}
        
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
	}
}

class Meat {
	int weight;
	int price;
	
	public Meat(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
}