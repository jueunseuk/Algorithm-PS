package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17479_정식당 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> basic = new HashMap<>();
        Map<String, Integer> special = new HashMap<>();
        Set<String> service = new HashSet<>();
        
        for(int i = 0; i < A; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	basic.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i < B; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	special.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i < C; i++) {
        	service.add(br.readLine());
        }
        
        int n = Integer.parseInt(br.readLine());
        
        long bp = 0;
        long spp = 0, spcnt = 0;
        long secnt = 0;
        
        for(int i = 0; i < n; i++) {
        	String input = br.readLine();
        	if(basic.containsKey(input)) {
        		bp += basic.get(input);
        	} else if(special.containsKey(input)) {
        		spp += special.get(input);
        		spcnt++;
        	} else {
        		secnt++;
        	}
        }
        
        if(spcnt > 0 && bp < 20000) {
        	System.out.println("No");
        	return;
        }
        
        if(secnt > 1) {
        	System.out.println("No");
        	return;
        }
        
        if((bp + spp) < 50000 && secnt == 1) {
        	System.out.println("No");
        	return;
        }
        
        System.out.println("Okay");
	}
}