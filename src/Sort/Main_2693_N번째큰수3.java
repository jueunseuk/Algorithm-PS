package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2693_N번째큰수3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = 0, n2 = 0, n3 = 0;
			
			int input;
			for(int i = 0; i < 10; i++) {
				input = Integer.parseInt(st.nextToken());
				if(input > n1) {
					n3 = n2;
					n2 = n1;
					n1 = input;
				} else {
					if(input > n2) {
						n3 = n2;
						n2 = input;
					} else {
						if(input > n3) {
							n3 = input;
						}
					}
				}
			}
			
			sb.append(n3+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}