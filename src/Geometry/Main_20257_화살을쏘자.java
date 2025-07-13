package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20257_화살을쏘자 {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Map<Double, Integer> map1 = new HashMap<>();
    	Map<Double, Integer> map2 = new HashMap<>();
    	Map<Double, Integer> map3 = new HashMap<>();
    	Map<Double, Integer> map4 = new HashMap<>();
    	int axis[] = new int[4];
    	
    	StringTokenizer st;
    	double x, y, div;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		x = Double.parseDouble(st.nextToken());
    		y = Double.parseDouble(st.nextToken());
    		
    		if(x > 0) {
    			if(y > 0) {
    				div = y / x;
    				map1.put(div, map1.getOrDefault(div, 0)+1);
    			} else if(y < 0) {
    				div = y / x;
    				map4.put(div, map4.getOrDefault(div, 0)+1);
    			} else {
    				axis[0]++;
    			}
    		} else if(x < 0) {
    			if(y > 0) {
    				div = y / x;
    				map2.put(div, map2.getOrDefault(div, 0)+1);
    			} else if(y < 0) {
    				div = y / x;
    				map3.put(div, map3.getOrDefault(div, 0)+1);
    			} else {
    				axis[2]++;
    			}
    		} else {
    			if(y > 0) {
    				axis[1]++;
    			} else {
    				axis[3]++;
    			}
    		}
    	}
    	
    	int max = 0;
    	for(Map.Entry<Double, Integer> e : map1.entrySet()) {
    		max = Math.max(max, e.getValue());
    	}
    	for(Map.Entry<Double, Integer> e : map2.entrySet()) {
    		max = Math.max(max, e.getValue());
    	}
    	for(Map.Entry<Double, Integer> e : map3.entrySet()) {
    		max = Math.max(max, e.getValue());
    	}
    	for(Map.Entry<Double, Integer> e : map4.entrySet()) {
    		max = Math.max(max, e.getValue());
    	}
    	for(int out : axis) {
    		max = Math.max(max, out);
    	}
    	
    	System.out.println(max);
	}

}
