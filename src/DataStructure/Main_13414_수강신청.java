package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_13414_수강신청 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        int order = 0;
        for(int i = 0; i < q; i++) {
        	map.put(br.readLine(), order++);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> l : list) {
        	sb.append(l.getKey()).append("\n");
        	if(++cnt == n) break;
        }
        
        System.out.println(sb.toString().trim());
	}
}