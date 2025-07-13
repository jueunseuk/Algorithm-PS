package Bitmask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int set = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			int number = 0;
			
			if(st.hasMoreTokens())
				number = Integer.parseInt(st.nextToken());
			
			switch(command) {
				case "add" : {
					set |= 1 << number;
					break;
				}
				case "check" : {
					sb.append((set & 1 << number) != 0 ? 1 : 0).append("\n");
					break;
				}
				case "remove" : {
					set &= ~(1 << number);
					break;
				}
				case "toggle" : {
					set ^= 1 << number;
					break;
				}
				case "all" : {
					set |= (1 << 21)-1;
					break;
				}
				case "empty" : {
					set = 0;
					break;
				}
				
			}
		}
		System.out.println(sb);
	}

}
