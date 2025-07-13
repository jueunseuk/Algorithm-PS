package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19532_수학은비대면강의 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input[] = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< 6; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int x = -999; x <= 999; x++) {
			for(int y = -999; y <= 999; y++) {
				if((x*input[0]+y*input[1] == input[2])) {
					if((x*input[3]+y*input[4] == input[5]))	{
						System.out.println(x+" "+y);
						return;
					}
					
				}
			}
		}
	}
}
