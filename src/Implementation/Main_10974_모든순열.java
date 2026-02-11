package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10974_모든순열 {
	static int n;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = i+1;
        }
        
        int size = 1;
        for(int i = 1; i <= n; i++) {
        	size *= i;
        }
        
        append();
        for(int i = 0; i < size; i++) {
        	nextPermutation();
        }
        
        System.out.println(sb.toString().trim());
	}
	
	private static void append() {
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]);
			if(i < n-1) sb.append(" ");
		}
		sb.append("\n");
	}

	private static void nextPermutation() {
		int idx = n - 1;
		while (idx > 0 && arr[idx - 1] > arr[idx]) {
			idx--;
		}
		
		if (idx == 0) {
			return;
		}

		int big_idx = n - 1;
		while (big_idx > idx && arr[idx - 1] > arr[big_idx]) {
			big_idx--;
		}

		int temp = arr[idx - 1];
		arr[idx - 1] = arr[big_idx];
		arr[big_idx] = temp;

		Arrays.sort(arr, idx, n);
		append();
	}
}
