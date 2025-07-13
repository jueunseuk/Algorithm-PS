package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_1302_베스트셀러{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }
		
		List<String> list = new ArrayList<>(map.keySet());
		
		Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int countComparison = map.get(o2).compareTo(map.get(o1)); // 판매량을 기준으로 내림차순 정렬
                if (countComparison != 0) {
                    return countComparison;
                }
                return o1.compareTo(o2); // 판매량이 같다면 사전순 정렬
            }
        });
		
		System.out.println(list.get(0));
		
		
	}

}
