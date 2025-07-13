package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_22252_정보상인호석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, PriorityQueue<Integer>> map = new HashMap<>();
		
		long result = 0;
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine() ," ");
			int order = Integer.parseInt(st.nextToken());
			
			switch(order) {
				case 1: {
					String name = st.nextToken();
					int cnt = Integer.parseInt(st.nextToken());
					
					if(!map.containsKey(name)) {
						map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
					}
					
					PriorityQueue<Integer> temp = map.get(name);
					for(int j = 0; j < cnt; j++) {
						temp.offer(Integer.parseInt(st.nextToken()));
					}
					
					break;
				}
				case 2: {
					String name = st.nextToken();
					int cnt = Integer.parseInt(st.nextToken());
					
					if(!map.containsKey(name)) {
						continue;
					}
					
					PriorityQueue<Integer> temp = map.get(name);
					
					while(!temp.isEmpty() && cnt-- > 0) {
						result += map.get(name).poll();
					}
					
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}