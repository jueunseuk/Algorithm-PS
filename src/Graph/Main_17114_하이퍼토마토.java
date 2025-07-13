package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17114_하이퍼토마토 {
	static int m, n, o, p, q, r, s, t, u, v, w, max = 0;
	static int[][][][][][][][][][][] matrix;
	static boolean[][][][][][][][][][][] visit;
	
	static Queue<int[]> queue = new ArrayDeque<>();
	
	static int[] dw = {1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] dv = {0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] du = {0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] dt = {0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] ds = {0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] dr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] dq = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0};
	static int[] dp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0};
	static int[] doo ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0};
	static int[] dn = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0};
	static int[] dm = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        matrix = new int[w][v][u][t][s][r][q][p][o][n][m];
        visit = new boolean[w][v][u][t][s][r][q][p][o][n][m];
        
        for(int ww = 0; ww < w; ww++) {
        	for(int vv = 0; vv < v; vv++) {
            	for(int uu = 0; uu < u; uu++) {
            		for(int tt = 0; tt < t; tt++) {
            			for(int ss = 0; ss < s; ss++) {
            				for(int rr = 0; rr < r; rr++) {
            					for(int qq = 0; qq < q; qq++) {
            						for(int pp = 0; pp < p; pp++) {
            							for(int oo = 0; oo < o; oo++) {
            								for(int nn = 0; nn < n; nn++) {
            									st = new StringTokenizer(br.readLine(), " ");
            									for(int mm = 0; mm < m; mm++) {
            										matrix[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] = Integer.parseInt(st.nextToken());
            										if(matrix[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] == 1) {
            											queue.offer(new int[] {ww, vv, uu, tt, ss, rr, qq, pp, oo, nn, mm, 0});
            											visit[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] = true;
            										}
            									}
            								}
            							}
            						}
            					}
            				}
            			}
            		}
            	}
            }
        }
        
        while(!queue.isEmpty()) {
        	int[] poll = queue.poll();
        	
        	max = Math.max(max, poll[11]);
        	
        	for(int delta = 0; delta < 22; delta++) {
        		int nw = poll[0] + dw[delta];
        		int nv = poll[1] + dv[delta];
        		int nu = poll[2] + du[delta];
        		int nt = poll[3] + dt[delta];
        		int ns = poll[4] + ds[delta];
        		int nr = poll[5] + dr[delta];
        		int nq = poll[6] + dq[delta];
        		int np = poll[7] + dp[delta];
        		int no = poll[8] + doo[delta];
        		int nn = poll[9] + dn[delta];
        		int nm = poll[10] + dm[delta];
        		
        		if(nw < 0 || nv < 0 || nu < 0 || nt < 0 || ns < 0 || nr < 0 || nq < 0 || np < 0 || no < 0 || nn < 0 || nm < 0) {
        			continue;
        		}
        		if(nw >= w || nv >= v || nu >= u || nt >= t || ns >= s || nr >= r || nq >= q || np >= p || no >= o || nn >= n || nm >= m) {
        			continue;
        		}
        		if(visit[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm]) {
        			continue;
        		}
        		if(matrix[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] == 0) {
        			visit[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] = true;
        			matrix[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] = 1;
        			queue.offer(new int[] {nw, nv, nu, nt, ns, nr, nq, np, no, nn, nm, poll[11]+1});
        		}
        	}
        }
        
        for(int ww = 0; ww < w; ww++) {
        	for(int vv = 0; vv < v; vv++) {
            	for(int uu = 0; uu < u; uu++) {
            		for(int tt = 0; tt < t; tt++) {
            			for(int ss = 0; ss < s; ss++) {
            				for(int rr = 0; rr < r; rr++) {
            					for(int qq = 0; qq < q; qq++) {
            						for(int pp = 0; pp < p; pp++) {
            							for(int oo = 0; oo < o; oo++) {
            								for(int nn = 0; nn < n; nn++) {
            									for(int mm = 0; mm < m; mm++) {
            										if(matrix[ww][vv][uu][tt][ss][rr][qq][pp][oo][nn][mm] == 0) {
            											System.out.println(-1);
            											return;
            										}
            									}
            								}
            							}
            						}
            					}
            				}
            			}
            		}
            	}
            }
        }
        
        System.out.println(max);
	}

}
