package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2910_빈도정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			int input = Integer.parseInt(st.nextToken());
			map.put(input, map.getOrDefault(input, 0)+1);
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		
		list.sort((a, b) -> {
			return b.getValue()-a.getValue();
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Integer, Integer> entry : list) {
			for(int i = 0; i < entry.getValue(); i++)
			sb.append(entry.getKey()).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
