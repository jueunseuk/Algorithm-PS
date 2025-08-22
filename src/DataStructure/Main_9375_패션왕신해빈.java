package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();
				String kind = st.nextToken();
				
				if(!map.containsKey(kind)) {
					map.put(kind, 1);
				} else {
					map.put(kind, map.get(kind)+1);
				}
			}
			
			int multi = 1;
			for(Map.Entry<String, Integer> out : map.entrySet()) {
				multi *= out.getValue()+1;
			}
			
			multi--;
			
			sb.append(multi+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}