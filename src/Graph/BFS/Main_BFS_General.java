package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BFS_General {
	static int size, edge;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		size = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		
		visit = new boolean[size+1];
		for(int i = 0; i <= size; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		
		
	}
}