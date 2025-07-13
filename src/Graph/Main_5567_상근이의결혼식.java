package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5567_상근이의결혼식 {
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[];
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		visit = new boolean[size+1];
		
		for(int i = 0; i <= size; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			addData(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		bfs(1);
		
		System.out.println(result-1);
	}

	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			int current = arr[0];
			int depth = arr[1];
			
			if(depth > 2) break;
			
			result++;
			
			for(int out : list.get(current)) {
				if(!visit[out]) {
					q.add(new int[] {out, depth+1});
					visit[out] = true;
				}
			}
		}
	}

	public static void addData(int i, int j) {
		list.get(i).add(j);
		list.get(j).add(i);
	}

}
