package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_11652_카드 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
        	long input = Long.parseLong(br.readLine());
        	map.put(input, map.getOrDefault(input, 0)+1);
        }

        List<Long> candidate = new ArrayList<>();
        int max = 0;
        for(Map.Entry<Long, Integer> out : map.entrySet()) {
        	if(max < out.getValue()) {
        		candidate.clear();
        		candidate.add(out.getKey());
        		max = out.getValue();
        	} else if(max == out.getValue()) {
        		candidate.add(out.getKey());
        	}
        }
        
        Collections.sort(candidate);
        
        System.out.println(candidate.get(0));
	}
}