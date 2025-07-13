package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669 {

	public static void main(String[] args) throws IOException {
		int matrix[][] = new int[101][101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1 ; i <= 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int []input = new int[4];
			for(int j = 0; j < 4; j++) input[j] = Integer.parseInt(st.nextToken());
			
			for(int x = input[0]; x < input[2]; x++) {
				for(int y = input[1]; y < input[3]; y++) {
					matrix[x][y] = 1;
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				sum+= matrix[i][j];
			}
		}
		System.out.println(sum);

		br.close();
	}

}
