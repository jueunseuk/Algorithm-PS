package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13147_Dwarves {
	static int n = 10000, m;
	static Map<String, Integer> map = new HashMap<>();
	static List<List<Integer>> list = new ArrayList<>();
	static int top[];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n; i++) {
        	list.add(new ArrayList<>());
        }
        
        top = new int[n];
        
        int idx = 0;
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	String first = st.nextToken();
        	char oper = st.nextToken().charAt(0);
        	String second = st.nextToken();
        	
        	if(!map.containsKey(first)) {
        		map.put(first, idx++);
        	}
        	if(!map.containsKey(second)) {
        		map.put(second, idx++);
        	}
        	
        	if(oper == '>') {
        		list.get(map.get(first)).add(map.get(second));
        		top[map.get(second)]++;
        	} else {
        		list.get(map.get(second)).add(map.get(first));
        		top[map.get(first)]++;
        	}
        }
        
        topologicalSort();

        n = idx;
        for(int i = 0; i < n; i++) {
        	if(top[i] > 0) {
        		System.out.println("impossible");
        		return;
        	}
        }
        
        System.out.println("possible");
	}

	private static void topologicalSort() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int out : list.get(poll)) {
				if(--top[out] == 0) {
					q.offer(out);
				}
			}
		}
	}
}