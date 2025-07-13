package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1041_주사위 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int dice[] = new int[6];
		for(int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		int oneMin = Integer.MAX_VALUE;
		int twoMin = Integer.MAX_VALUE;
		int threeMin = Integer.MAX_VALUE;

		for(int i = 0; i < 6; i++) {
			oneMin = Math.min(dice[i], oneMin);
		}
		
		// 두 면의 합과 세 면의 합의 최솟값 구하기
		twoMin = Math.min(dice[0]+dice[1], twoMin);
		twoMin = Math.min(dice[0]+dice[2], twoMin);
		twoMin = Math.min(dice[0]+dice[3], twoMin);
		twoMin = Math.min(dice[0]+dice[4], twoMin);
		twoMin = Math.min(dice[5]+dice[1], twoMin);
		twoMin = Math.min(dice[5]+dice[2], twoMin);
		twoMin = Math.min(dice[5]+dice[3], twoMin);
		twoMin = Math.min(dice[5]+dice[4], twoMin);
		twoMin = Math.min(dice[1]+dice[2], twoMin);
        twoMin = Math.min(dice[1]+dice[3], twoMin);
        twoMin = Math.min(dice[2]+dice[4], twoMin);
        twoMin = Math.min(dice[3]+dice[4], twoMin);
			
		threeMin = Math.min(dice[0]+dice[1]+dice[2], threeMin);
		threeMin = Math.min(dice[0]+dice[1]+dice[3], threeMin);
		threeMin = Math.min(dice[0]+dice[4]+dice[2], threeMin);
		threeMin = Math.min(dice[0]+dice[4]+dice[3], threeMin);
		threeMin = Math.min(dice[5]+dice[1]+dice[2], threeMin);
		threeMin = Math.min(dice[5]+dice[1]+dice[3], threeMin);
		threeMin = Math.min(dice[5]+dice[4]+dice[2], threeMin);
		threeMin = Math.min(dice[5]+dice[4]+dice[3], threeMin);
		
		long result = 0;
		
		if(N == 1) {
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < 6; i++) {
				max = Math.max(dice[i], max);
			}
			for(int out : dice) {
				result += out;
			}
			System.out.println(result-max);
			return;
		} else if(N == 2) {
			result += (long) 4 * threeMin; 
		    result += (long) 4 * twoMin;
		    System.out.println(result);
		    return;
		} else {
			result =  4L * threeMin 
					+ 4L * (long)(N-1)*twoMin 
					+ 4L * (long)(N-2)*twoMin 
					+ 4L * (long)(N-1)*(N-2)*oneMin 
					+ 1L * (long)(N-2)*(N-2)*oneMin;
			System.out.println(result);
		}
	}

}
