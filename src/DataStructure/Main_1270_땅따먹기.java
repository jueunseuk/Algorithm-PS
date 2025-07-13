package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1270_땅따먹기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int cnt = Integer.parseInt(st.nextToken());
        	Map<Long, Integer> map = new HashMap<>();
        	for(int j = 0; j < cnt; j++) {
        		long input = Long.parseLong(st.nextToken());
    			map.put(input, map.getOrDefault(input, 0)+1);
        	}
        	long result = 0;
        	for(Map.Entry<Long, Integer> out : map.entrySet()) {
        		if(out.getValue() > cnt/2) {
        			result = out.getKey();
        			break;
        		}
        	}
        	sb.append(result == 0 ? "SYJKGW" : result).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}