package Graph.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_23817_포항항 {
	static final int INF = 1000000000;
	
	static int row, col, fish, min = Integer.MAX_VALUE;
	static int[][] matrix;
	static boolean[][] visit;
	static List<Restaurant> rest = new ArrayList<>();
	static List<List<int[]>> list = new ArrayList<>();
	
	static final int dx[] = {0, 0, 1, -1};
	static final int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new int[row][col];
		
		int si = -1, idx = 0;
		for(int i = 0; i < row; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < col; j++) {
				if(input[j] == '.') {
					matrix[i][j] = -1;
				} else if(input[j] == 'K') {
					matrix[i][j] = idx;
					rest.add(new Restaurant(i, j, idx++));
				} else if(input[j] == 'X') {
					matrix[i][j] = -2;
				} else if(input[j] == 'S') {
					si = idx;
					matrix[i][j] = -1;
					rest.add(new Restaurant(i, j, idx++));
				}
			}
		}
		
		fish = idx;
		
		for(int i = 0; i < 420; i++) {
			list.add(new ArrayList<>());
		}
		
		int[][] W = new int[fish][fish];
        for(int[] a : W) Arrays.fill(a, INF);
        for(int a = 0; a < fish; a++) W[a][a] = 0;

        for(int a = 0; a < fish; a++) {
            int[][] dist = new int[row][col];
            
            for(int[] d : dist) Arrays.fill(d, -1);
            
            ArrayDeque<int[]> q = new ArrayDeque<>();
            Restaurant s = rest.get(a);
            
            q.offer(new int[]{s.x, s.y});
            dist[s.x][s.y] = 0;
            
            while(!q.isEmpty()) {
                int[] p = q.poll();
                
                for(int d = 0; d < 4; d++) {
                    int nx = p[0] + dx[d], ny = p[1] + dy[d];
                    
                    if(!rangeCheck(nx, ny) || matrix[nx][ny] == -2 || dist[nx][ny] != -1) continue;
                    
                    dist[nx][ny] = dist[p[0]][p[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
            
            for(int b = 0; b < fish; b++) {
                Restaurant t = rest.get(b);
                if(dist[t.x][t.y] != -1) W[a][b] = dist[t.x][t.y];
            }
        }
		
        int reachable = 0;
        for(int v = 0; v < fish; v++) {
        	if(v != si && W[si][v] < INF) reachable++;
        }
        
        if(reachable < 5) {
            System.out.println(-1);
            return;
        }

        int K = fish - 1;
        int[] kNodes = new int[K];
        int bi = 0;
        for(int v = 0; v < fish; v++) {
        	if(v != si) kNodes[bi++] = v;
        }

        int MAXMASK = 1 << K;
        int[][] dp = new int[MAXMASK][K];
        for(int[] d : dp) {
        	Arrays.fill(d, INF);
        }

        for(int i = 0; i < K; i++) {
            int v = kNodes[i];
            if(W[si][v] < INF) dp[1 << i][i] = W[si][v];
        }

        for(int bc = 1; bc <= 4; bc++) {
            for(int mask = 0; mask < MAXMASK; mask++) {
                if(Integer.bitCount(mask) != bc) continue;
                for (int last = 0; last < K; last++) {
                    if((mask & (1 << last)) == 0) continue;
                    int cur = dp[mask][last];
                    if(cur >= INF) continue;
                    int u = kNodes[last];
                    for(int nxt = 0; nxt < K; nxt++) {
                        if((mask & (1 << nxt)) != 0) continue;
                        int v = kNodes[nxt];
                        if(W[u][v] >= INF) continue;
                        int nmask = mask | (1 << nxt);
                        int nc = cur + W[u][v];
                        if(nc < dp[nmask][nxt]) dp[nmask][nxt] = nc;
                    }
                }
            }
        }

        int ans = INF;
        for(int mask = 0; mask < MAXMASK; mask++) {
            if(Integer.bitCount(mask) != 5) continue;
            
            for(int last = 0; last < K; last++) {
                if((mask & (1 << last)) == 0) continue;
                ans = Math.min(ans, dp[mask][last]);
            }
        }

        System.out.println(ans >= INF ? -1 : ans);
	}

	private static boolean rangeCheck(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
	
	public static class Restaurant {
		int x, y, idx;

		public Restaurant(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}
}