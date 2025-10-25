package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292_쉽게푸는문제 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int idx = 1;
        int[] arr = new int[1001];
        for(int i = 1; i <= 1000; i++) {
        	for (int j = 0; j < i && idx <= 1000; j++) {
                arr[idx++] = i;
            }
        }

        for(int i = 1; i <= 1000; i++) {
        	arr[i] += arr[i-1];
        }
        
        System.out.println(arr[b]-arr[a-1]);
	}
}