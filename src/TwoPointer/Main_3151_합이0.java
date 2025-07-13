package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_3151_합이0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
                
        for (int i = 0; i < n-2; i++) {
        	int left = i+1;
        	int right = n-1;
        	
            while(left < right) {
            	int sum = arr[i]+arr[left]+arr[right];
            	
            	if(sum == 0) {
            		
            	}
            	
            	if(sum >= 0) {
            		right--;
            	} else {
            		left++;
            	}
            }
        }
        
        System.out.println();
    }
}
