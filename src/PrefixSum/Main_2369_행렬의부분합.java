package PrefixSum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2369_행렬의부분합 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        
        int input[][] = new int[row][col];
        int sum[][] = new int[row][col];
        
        for(int i = 0; i < row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < col; j++) {
        		input[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // sum 초기 조건
        for(int i = 0; i < row; i++) {
        	sum[i][0] = input[i][0];
        }
        
        // row sum
        for(int i = 0; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		sum[i][j] = sum[i][j-1] + input[i][j];
        	}
        }
        
        // col sum
        for(int i = 0; i < col; i++) {
        	for(int j = 1; j < row; j++) {
        		sum[j][i] += sum[j-1][i];
        	}
        }
        
        int cnt = 0;
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(sum[i][j] % mod == 0) {
        			cnt++;
        		}
        	}
        }
        
        for(int i = 0 ; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		for(int k = 0; k < j; k++) {
        			if((sum[i][j]-sum[i][k]) % mod == 0) {
        				cnt++;
        			}
        		}
        	}
        }
        
        for(int i = 0; i < col; i++) {
        	for(int j = 1; j < row; j++) {
        		for(int k = 0; k < j; k++) {
        			if((sum[j][i]-sum[k][i]) % mod == 0) {
        				cnt++;
        			}
        		}
        	}
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                for (int r = 0; r < i; r++) {
                    for (int c = 0; c < j; c++) {
                        if ((sum[i][j] - sum[r][j] - sum[i][c] + sum[r][c]) % mod == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        
        System.out.println(cnt);
	}
}