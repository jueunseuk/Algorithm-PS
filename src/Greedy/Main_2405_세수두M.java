package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2405_세수두M {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int input[] = new int[n];
		int avg[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		int tempSum = input[0]+input[n-1];
		for(int i = 1; i < n-1; i++) {
			avg[i] = (tempSum + input[i]);
		}
		
		int maxSub = Integer.MIN_VALUE;
		
		for(int i = 1; i < n-1; i++) {
			if(input[i]*3 >= avg[i]) {
				maxSub = Math.max(Math.abs((input[0]+input[i]+input[i+1]) - input[i]*3), maxSub);
			} else {
				maxSub = Math.max(Math.abs((input[i-1]+input[i]+input[n-1]) - input[i]*3), maxSub);
			}
		}
		
		System.out.println(maxSub);
	}

}

/*
 * 이 문제의 핵심은 정렬하고 중위값을 고정시킨 뒤에 
 * 평균과 중위값을 비교해서
 * i) 만약 평균값이 중위값보다 작다면
 * 		세 수 중에 가장 큰 값을 현재 중위값 다음 값으로 설정해야함
 * ii) 만약 평균값이 중위값보다 크다면
 * 		세 수 중에 가장 작은 값을 현재 중위값 이전 값으로 설정해야함
 * 
 * 이유 => 각각의 중위값에 대해 평균이 멀어지도록 만들어줌
 * 
 * */
