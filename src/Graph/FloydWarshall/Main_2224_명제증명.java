package Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2224_명제증명 {
	static final int INF = 100000000;
	
	static int n;
	static int[][] matrix = new int[52][52];
	static Map<Integer, Character> iToC = new HashMap<>();
	static Map<Character, Integer> cToI = new HashMap<>();	
	
	static StringBuilder sb = new StringBuilder();
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < 52; i++) {
        	Arrays.fill(matrix[i], INF);
        	matrix[i][i] = 0;
        }
        
        int idx = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " => ");
        	char a = st.nextToken().charAt(0);
        	char b = st.nextToken().charAt(0);
        	
        	int start = 0;
        	int end = 0;
        	if(cToI.containsKey(a)) {
        		start = cToI.get(a);
        	} else {
        		iToC.put(idx, a);
        		cToI.put(a, idx);
        		start = idx++;
        	}
        	
        	if(cToI.containsKey(b)) {
        		end = cToI.get(b);
        	} else {
        		iToC.put(idx, b);
        		cToI.put(b, idx);
        		end = idx++;
        	}
        	
        	matrix[start][end] = 1;
        }
        
        for(int k = 0; k < 52; k++) {
        	for(int i = 0; i < 52; i++) {
        		for(int j = 0; j < 52; j++) {
        			matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
        		}
        	}
        }
        
        List<String> out = new ArrayList<>();
        for(int i = 0; i < 52; i++) {
            for(int j = 0; j < 52; j++) {
                if(i == j) continue;
                if(matrix[i][j] < INF) {
                    out.add(iToC.get(i) + " => " + iToC.get(j));
                }
            }
        }
        
        Collections.sort(out);
        System.out.println(out.size());
        for(String s : out) {
        	sb.append(s+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}