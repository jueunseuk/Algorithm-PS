package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int score[] = new int[N];
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			
			double avg = sum/N;
			
			double cnt = 0;
			
			for(int j = 0; j < N; j++) if(score[j] > avg) cnt++;
				
			double ratio = cnt/N*100;
			
			
			System.out.printf("%.3f", ratio);
			System.out.println("%");
		}
		
	}

}
