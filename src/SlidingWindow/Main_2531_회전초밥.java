package SlidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int kind = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken());
		
		int length = n+k;
		int[] input = new int[length];
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if(i < k) {
				input[i+n] = input[i];
			}
		}
		
		int cnt[] = new int[kind+1];
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < k; i++) {
			cnt[input[i]]++;
			set.add(input[i]);
		}
		
		int max = set.size();
		if(!set.contains(coupon)) max++;
		
		int left = 0;
		int right = k-1;
		int curr = max;
		while(true) {
			left++;
			right++;
			
			if(right >= length) break;
			
			if(++cnt[input[right]] == 1) {
				set.add(input[right]);
			}
			
			if(--cnt[input[left-1]] == 0) {
				set.remove(input[left-1]);
			}
			
			curr = set.size();
			
			if(!set.contains(coupon)) {
				curr++;
			}
			
			max = Math.max(max, curr);
		}
		
		System.out.println(max);
	}
}