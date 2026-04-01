package Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16169_수행시간 {
	static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] top;
    static int[] time;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        }
        
        top = new int[n+1];
        time = new int[n+1];
        
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int c = Integer.parseInt(st.nextToken());
        		int s = Integer.parseInt(st.nextToken());
        		
        		list.get(i).add(c);
        }
        
	}

}
