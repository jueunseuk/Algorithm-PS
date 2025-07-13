package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int high[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			high[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = n; i >= 1; i--) {
            list.add(high[i - 1], i);
        }

		StringBuilder sb = new StringBuilder();
        for (int out : list) {
        	sb.append(out).append(" ");
        }
		System.out.println(sb.toString().trim());
	}

}
