package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_21944_문제추천시스템2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TreeSet<Problem> ts = new TreeSet<>();
		Map<Integer, TreeSet<Problem>> total = new HashMap<>();
		Map<Integer, Integer> level = new HashMap<>();
		Map<Integer, Integer> category = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int lev = Integer.parseInt(st.nextToken());
			int cat = Integer.parseInt(st.nextToken());
			
			ts.add(new Problem(num, lev, cat));
			
			if(total.containsKey(cat)) {
				total.get(cat).add(new Problem(num, lev, cat));
			} else {
				TreeSet<Problem> temp = new TreeSet<>();
				temp.add(new Problem(num, lev, cat));
				total.put(cat, temp);
			}
			level.put(num, lev);
			category.put(num, cat);
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
					int cat = Integer.parseInt(st.nextToken());
					
					ts.add(new Problem(num, lev, cat));
					total.computeIfAbsent(cat, k -> new TreeSet<>()).add(new Problem(num, lev, cat));
					level.put(num, lev);
					category.put(num, cat);
					break;
				}
				case "recommend" : {
					int input = Integer.parseInt(st.nextToken());
					int delta = Integer.parseInt(st.nextToken());
					
					if(delta == 1) {
						sb.append(total.get(input).last().num+"\n");
					} else {
						sb.append(total.get(input).first().num+"\n");
					}
					break;
				}
				case "recommend2" : {
					int delta = Integer.parseInt(st.nextToken());
					
					if(delta == 1) {
						sb.append(ts.last().num+"\n");
					} else {
						sb.append(ts.first().num+"\n");
					}
					break;
				}
				case "recommend3" : {
					int delta = Integer.parseInt(st.nextToken());
					int input = Integer.parseInt(st.nextToken());
					
					if(delta == 1) {
						if(ts.ceiling(new Problem(0, input, 0)) == null) {
							sb.append(-1+"\n");
						} else {
							sb.append(ts.ceiling(new Problem(0, input, 0)).num+"\n");
						}
					} else {
						if(ts.floor(new Problem(0, input, 0)) == null) {
							sb.append(-1+"\n");
						} else {
							sb.append(ts.floor(new Problem(0, input, 0)).num+"\n");
						}
					}
					break;
				}
				case "solved" : {
					int num = Integer.parseInt(st.nextToken());
					int lev = level.get(num);
					int cat = category.get(num);
					
					ts.remove(new Problem(num, lev, cat));
					total.get(cat).remove(new Problem(num, lev, cat));
					level.remove(num);
					category.remove(num);
					break;
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}

	public static class Problem implements Comparable<Problem> {
		int num, lev, cat;

		public Problem(int num, int lev, int cat) {
			this.num = num;
			this.lev = lev;
			this.cat = cat;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.lev == o.lev) {
				return this.num - o.num;
			}
			return this.lev - o.lev;
		}
	}
}