package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_12892_생일선물 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        Friend[] friend = new Friend[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	friend[i] = new Friend(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        if(n == 1) {
        	System.out.println(friend[0].value);
        	return;
        }
        
        Arrays.sort(friend, new Comparator<Friend>() {
			@Override
			public int compare(Friend o1, Friend o2) {
				return o1.price - o2.price;
			}
        });
        
        int left = 0, right = 0;
        long currSum = 0, maxSum = 0;
        while(right < n) {
        	if(friend[right].price - friend[left].price < d) {
        		currSum += friend[right].value;
        		right++;
        	} else {
        		currSum -= friend[left].value;
        		left++;
        	}
        	maxSum = Math.max(maxSum, currSum);
        }
        
        System.out.println(maxSum);

	}
	
	static class Friend {
		int price;
		int value;
		
		public Friend(int price, int value) {
			this.price = price;
			this.value = value;
		}
	}
}