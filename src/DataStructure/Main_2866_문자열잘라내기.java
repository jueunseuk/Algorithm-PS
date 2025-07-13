package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2866_문자열잘라내기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		StringBuilder[] sb = new StringBuilder[col];
		
		for(int i = 0; i < col; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i = 0; i < row; i++) {
			String input[] = br.readLine().split("");
			
			for(int j = 0; j < col; j++) {
				sb[j].append(input[j]);
			}
		}
		
		int cnt = -1;
		Set<String> set;
		
		escape:
		for(int k = 0; k < row; k++) {
			set = new HashSet<>();
			
			for(int i = 0; i < col; i++) {
				if(set.contains(sb[i].toString())) {
					break escape;
				}
				set.add(sb[i].toString());
			}
			
			cnt++;
			
			for(int i = 0; i < col; i++) {
				sb[i].deleteCharAt(0);
			}
		}
		
		System.out.println(cnt);
	}

}
