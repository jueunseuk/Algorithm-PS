package Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_13168_내일로여행 {
	static final int INF = 1000000007;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Set<String> free = new HashSet<>();
        free.add("ITX-Saemaeul");
        free.add("ITX-Cheongchun");
        free.add("Mugunghwa");
        
        Set<String> half = new HashSet<>();
        half.add("S-Train");
        half.add("V-Train");
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int ticket = Integer.parseInt(st.nextToken()) << 1;
        
        int idx = 0;
        Map<String, Integer> cityToIndex = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	String name = st.nextToken();
        	if(!cityToIndex.containsKey(name)) {
        		cityToIndex.put(name, idx++);
        	}
        }
        n = idx;
        
        int m = Integer.parseInt(br.readLine());
        int[] path = new int[m];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
        	path[i] = cityToIndex.get(st.nextToken());
        }
        
        int mm = Integer.parseInt(br.readLine());
        
        int[][][] matrix = new int[n][n][2];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		matrix[i][j][0] = INF;
        		matrix[i][j][1] = INF;
        	}
        	matrix[i][i][0] = 0;
        	matrix[i][i][1] = 0;
        }
        
        for(int i = 0; i < mm; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	String method = st.nextToken();
        	int start = cityToIndex.get(st.nextToken());
        	int end = cityToIndex.get(st.nextToken());
        	int c = Integer.parseInt(st.nextToken()) << 1;
        	
        	matrix[start][end][0] = Math.min(matrix[start][end][0], c);
        	matrix[end][start][0] = Math.min(matrix[end][start][0], c);
        	
        	if(free.contains(method)) {
        		matrix[start][end][1] = Math.min(matrix[start][end][1], 0);
        		matrix[end][start][1] = Math.min(matrix[end][start][1], 0);
        	} else if(half.contains(method)) {
        		matrix[start][end][1] = Math.min(matrix[start][end][1], c >> 1);
        		matrix[end][start][1] = Math.min(matrix[end][start][1], c >> 1);
        	} else {
        		matrix[start][end][1] = Math.min(matrix[start][end][1], c);
        		matrix[end][start][1] = Math.min(matrix[end][start][1], c);
        	}
        }
        
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			matrix[i][j][0] = Math.min(matrix[i][j][0], matrix[i][k][0] + matrix[k][j][0]);
        			matrix[i][j][1] = Math.min(matrix[i][j][1], matrix[i][k][1] + matrix[k][j][1]);
        		}
        	}
        }
        
        int sum1 = 0, sum2 = ticket;
        for(int i = 1; i < m; i++) {
        	sum1 += matrix[path[i]][path[i-1]][0];
        	sum2 += matrix[path[i]][path[i-1]][1];
        }
        
        System.out.println(sum1 > sum2 ? "Yes" : "No");
	}
}
