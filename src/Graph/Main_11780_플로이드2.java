package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11780_플로이드2 {
	static int n, m;
	static Section[][] result;
	static final int INF = 100_000_000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        result = new Section[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		result[i][j] = new Section(i, j);
        		if(i == j) {
        			result[i][j].updateCost(0);
        		}
        	}
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	if (cost < result[start][end].cost) {
        	    result[start][end].updateCost(cost);

        	    result[start][end].history.clear();
        	    result[start][end].history.add(start);
        	    result[start][end].history.add(end);
        	}
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		if (result[i][k].cost == INF) continue;
        		
        		for(int j = 1; j <= n; j++) {
        			if(result[k][j].cost == INF) continue;
        			
        			if(result[i][j].cost > result[i][k].cost + result[k][j].cost) {
        				result[i][j].updateCost(result[i][k].cost + result[k][j].cost);
        				result[i][j].updateHistory(result[i][k].history, result[k][j].history);
        			}
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		sb.append(result[i][j].cost == INF ? 0 : result[i][j].cost).append(" ");
        	}
        	sb.deleteCharAt(sb.length()-1).append("\n");
        }
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(result[i][j].history.size() == 0) {
        			sb.append(0);
        		} else {
        			sb.append(result[i][j].history.size()+" ");
        			for(int out : result[i][j].history) {
        				sb.append(out+" ");
        			}
        			sb.deleteCharAt(sb.length()-1);
        		}
        		sb.append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}
	
	public static class Section {
		int x, y, cost;
		List<Integer> history;
		
		public Section(int x, int y) {
			this.x = x;
			this.y = y;
			this.cost = INF;
			this.history = new ArrayList<>();
		}
		
		public void updateCost(int cost) {
			this.cost = cost;
		}
		
		public void updateHistory(List<Integer> first, List<Integer> second) {
		    history = new ArrayList<>(first.size() + second.size());
		    history.addAll(first);
		    
		    for (int idx = 1; idx < second.size(); idx++) {
		        history.add(second.get(idx));
		    }
		}
	}
}