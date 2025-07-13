package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14496_그대그머가되어 {
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	static int start, end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			addData(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(bfs(start));
	}
	
	private static int bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {start, 0});
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int current[] = q.poll();
			int node = current[0];
			int depth = current[1];
			
			if(node == end) {
				return depth;
			}
						
			for(int out : list.get(node)) {
				if(!visit[out]) {
					q.add(new int[] {out, depth+1});
					visit[out] = true;
				}
			}
		}
		
		return -1;
	}

	public static void addData(int i, int j) {
		list.get(i).add(j);
		list.get(j).add(i);
	}

}
