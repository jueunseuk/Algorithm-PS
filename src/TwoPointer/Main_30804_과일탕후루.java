package TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_30804_과일탕후루 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] input = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < n; right++) {
            map.put(input[right], map.getOrDefault(input[right], 0) + 1);

            while (map.size() > 2) {
                map.put(input[left], map.get(input[left]) - 1);
                if (map.get(input[left]) == 0) {
                    map.remove(input[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
	}
}