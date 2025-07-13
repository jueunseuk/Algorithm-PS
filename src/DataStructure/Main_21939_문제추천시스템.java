package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_21939_문제추천시스템 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Integer> map = new HashMap<>();
		
		TreeSet<Problem> ts = new TreeSet<>((o1, o2) -> {
			if (o1.lev == o2.lev) {
				return o1.num - o2.num;
			}
			return o1.lev - o2.lev;
		});
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int lev = Integer.parseInt(st.nextToken());
			ts.add(new Problem(num, lev));
			map.put(num, lev);
		}
		
		int query = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			
			switch(order) {
				case "add" : {
					int num = Integer.parseInt(st.nextToken());
					int lev = Integer.parseInt(st.nextToken());
					ts.add(new Problem(num, lev));
					map.put(num, lev);
					break;
				}
				case "recommend" : {
					int delta = Integer.parseInt(st.nextToken());
					if(delta == 1) {
						sb.append(ts.last().num+"\n");
					} else {
						sb.append(ts.first().num+"\n");
					}
					break;
				}
				case "solved" : {
					int num = Integer.parseInt(st.nextToken());
					ts.remove(new Problem(num, map.get(num)));
					break;
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}

	public static class Problem {
		int num, lev;

		public Problem(int num, int lev) {
			this.num = num;
			this.lev = lev;
		}
	}
}
