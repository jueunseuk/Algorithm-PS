package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22945_팀빌딩 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int input[] = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0, right = n-1;
        long max = 0, curr = 0;
        while(left < right) {
        	curr = (right-left-1)*Math.min(input[right], input[left]);
        	
        	max = Math.max(max, curr);
        	
        	if(input[right] < input[left]) {
        		right--;
        	} else if(input[right] > input[left]){
        		left++;
        	} else {
        		right--;
        		left++;
        	}
        }
        
        System.out.println(max);
	}
}