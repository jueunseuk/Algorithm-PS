package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20920_영단어암기장 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < N; i++) {
			String input = br.readLine();
			if(input.length() >= M) {
				map.put(input, map.getOrDefault(input, 0)+1);
			}
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		list.sort((a, b) -> {
			if(a.getValue() == b.getValue() && a.getKey().length() == b.getKey().length()) {
				return a.getKey().compareTo(b.getKey());
			} else if(a.getValue() == b.getValue()) {
				return b.getKey().length()-a.getKey().length();
			} else {
				return b.getValue().compareTo(a.getValue());
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
		
		System.out.println(sb.toString());
		
	}

}
