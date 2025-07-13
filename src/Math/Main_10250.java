package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int H, W, N;
		
		for(int i = 0 ; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int floor = N % H == 0 ? H : N % H;
            int roomNumber = (N - 1) / H + 1;
			
			sb.append(floor);
			
			if (roomNumber < 10) {
                sb.append('0');
            }
            sb.append(roomNumber);
            sb.append('\n');
			
			
		}
		System.out.println(sb.toString());
		
		br.close();
	}//main

}
