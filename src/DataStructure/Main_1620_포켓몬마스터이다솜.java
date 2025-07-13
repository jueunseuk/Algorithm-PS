package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> num = new HashMap<>();
		Map<String, Integer> str = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			String input = br.readLine();
			num.put(i, input);
			str.put(input, i);
		}
		
		for(int i = 0; i < m; i++) {
			String problem = br.readLine();
			if(str.containsKey(problem)) {
				System.out.println(str.get(problem));
			} else {
				int k = Integer.parseInt(problem);
				System.out.println(num.get(k));
			}
		}
	}
}
