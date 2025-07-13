package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Main_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < n; i++) {
			map.put(br.readLine(), 0);
		}
		for(int i = 0; i < m; i++) {
			String temp = br.readLine();
			map.computeIfPresent(temp, new BiFunction<String, Integer, Integer>() {
				@Override
				public Integer apply(String t, Integer u) {
					return u+1;
				}
			});
		}
		
		int sum = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			sum += entry.getValue();
			
		}
		System.out.println(sum);
		
	}

}
