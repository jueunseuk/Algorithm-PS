package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_DP3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 계단 개수
		int score[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		int i = 0;
		while(i< N-1) {
			if(i==0) {
				sum += score[i];
				i+=1;
			}
			else if(i == N-2) {
				sum += score[i];
				break;
			}
			else if(score[i] < score[i+1]) {
				sum += score[i+1];
				i+=2;
			}
			else {
				sum += score[i];
				i+=1;
			}
		}
		System.out.println(sum);
		
	}

}
