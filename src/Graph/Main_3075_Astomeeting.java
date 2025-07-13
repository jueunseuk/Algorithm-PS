package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3075_Astomeeting {
	static final int INF = 10000000;

	static int p, n, m;
	static long[][] result;
	static int[] person;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	p = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());

        	person = new int[101];
        	result = new long[n+1][n+1];

        	for(int i = 0; i < p; i++) {
        		person[Integer.parseInt(br.readLine())]++;
        	}

        	for(int i = 1; i <= n; i++) {
        		Arrays.fill(result[i], INF);
        		result[i][i] = 0;
        	}

        	for(int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());

        		result[start][end] = Math.min(result[start][end], c);
        		result[end][start] = Math.min(result[end][start], c);
        	}
        	
        	for(int k = 1; k <= n; k++) {
        		for(int i = 1; i <= n; i++) {
        			for(int j = 1; j <= n; j++) {
        				result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
        			}
        		}
        	}
        	
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] *= result[i][j];
        		}
        	}
        	
        	long min = Long.MAX_VALUE;
        	int num = 0;
        	for(int i = 1; i <= n; i++) {
        		long sum = 0;
        		for(int j = 1; j <= 100; j++) {
        			if(person[j] != 0) {
        				sum = sum + person[j]*result[i][j];
        			}
        		}
        		
        		if(min > sum) {
        			num = i;
        			min = sum;
        		}
        	}
        	
        	sb.append(num+" "+min+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}