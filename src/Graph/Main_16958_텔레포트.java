package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16958_텔레포트 {
	static final int INF = 100000000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        
        int result[][] = new int[size][size];
        for(int i = 0; i < size; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        int list[][] = new int[size][3];
        for(int i = 0; i < size; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list[i][0] = Integer.parseInt(st.nextToken());
        	list[i][1] = Integer.parseInt(st.nextToken());
        	list[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		int dist = Math.abs(list[i][1]-list[j][1]) + Math.abs(list[i][2]-list[j][2]);
        		
        		if(list[i][0] == 1 && list[j][0] == 1) {
        			result[i][j] = Math.min(dist, time);
        		} else {
        			result[i][j] = dist;
        		}
        	}
        }
        
        for(int k = 0 ; k < size; k++) {
        	for(int i = 0; i < size; i++) {
        		if(i == k) continue;
        		for(int j = 0; j < size; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int query = Integer.parseInt(br.readLine());
        for(int i = 0; i < query; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	sb.append(result[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}