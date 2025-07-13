package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static boolean visit[];
	static List<List<Integer>> list;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
		visit = new boolean[n+1];
		result = new int[n+1];
		
		StringTokenizer st;
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static void dfs(int current) {
		visit[current] = true;
		for(Integer next : list.get(current)) {
			if(!visit[next]) {
				result[next] = current;
				dfs(next);
			}
		}
	}

}
