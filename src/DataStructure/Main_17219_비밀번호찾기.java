package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17219_비밀번호찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	map.put(st.nextToken(), st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
        	sb.append(map.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

}
