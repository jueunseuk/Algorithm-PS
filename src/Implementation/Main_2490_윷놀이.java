package Implementation;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2490_윷놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			String[] input = br.readLine().split(" ");
			
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(input[j].equals("0")) {
					cnt++;
				}
			}
			
			switch(cnt) {
				case 0: {
					sb.append("E");
					break;
				}
				case 1: {
					sb.append("A");
					break;
				}
				case 2: {
					sb.append("B");
					break;
				}
				case 3: {
					sb.append("C");
					break;
				}
				case 4: {
					sb.append("D");
					break;
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}