package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int matrix[][];
	static boolean visit[][];
	static int size, cnt = 0, maxCnt = 0, maxTry = 0;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        
        matrix = new int[size][size];
        visit = new boolean[size][size];
        
        StringTokenizer st;
        for(int i = 0; i < size; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < size; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(maxTry < matrix[i][j]) {
        			maxTry = matrix[i][j];
        		}
        	}
        }
        
        for(int water = 0; water < maxTry; water++) {
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
        			if(!visit[i][j] && matrix[i][j] > water) {
        				dfs(i, j, water);
        				cnt++;
        			}
        		}
        	}
        	
        	maxCnt = Math.max(maxCnt, cnt);
        	cnt = 0;
        	visit = new boolean[size][size];
        }
        
        System.out.println(maxCnt);
        
	}

	private static void dfs(int i, int j, int water) {
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx >= 0 && nx < size && ny >= 0 && ny < size && !visit[nx][ny] && matrix[nx][ny] > water) {
				dfs(nx, ny, water);
			}
		}
	}

}
