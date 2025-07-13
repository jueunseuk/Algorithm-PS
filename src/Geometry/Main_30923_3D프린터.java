package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30923_3D프린터 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	sum += arr[i]*2;
        }
        
        sum += n*2;
        
        // 왼쪽에서
        long curr = 0;
        for(int i = 0; i < n; i++) {
        	if(arr[i] > curr) {
        		sum += arr[i] - curr;
        	}
        	curr = arr[i];
        }
        
        // 오른족에서
        curr = 0;
        for(int i = n-1; i >= 0; i--) {
        	if(arr[i] > curr) {
        		sum += arr[i] - curr;
        	}
        	curr = arr[i];
        }
        
        System.out.println(sum);
	}

}
