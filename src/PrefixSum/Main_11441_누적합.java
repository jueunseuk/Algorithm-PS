package PrefixSum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11441_누적합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int number = Integer.parseInt(br.readLine());
		int []numberArr = new int[number];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < number; i++) {
			numberArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int target = Integer.parseInt(br.readLine());
		int [][]targetArr = new int[target+1][2];
		for(int i = 1; i <= target; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				targetArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        int[] sum = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            sum[i] = sum[i - 1] + numberArr[i - 1];
        }
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= target; i++) {
				sb.append(sum[targetArr[i][1]]-sum[targetArr[i][0]-1]).append("\n");				
		}
		
		System.out.println(sb.toString());
	}

}
