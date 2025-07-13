package Sweeping;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2024_선분덮기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		List<int[]> input = new ArrayList<>();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int arr[] = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			
			if(arr[0] == 0 && arr[1] == 0) break;
			
			input.add(arr);
		}
		
		Collections.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0]-o2[0];
            }
        });
		
		int covered = 0;
        int cnt = 0;
        int i = 0;
        
		while (covered < target) {
            int maxReach = covered;

            while (i < input.size() && input.get(i)[0] <= covered) {
                maxReach = Math.max(maxReach, input.get(i)[1]);
                i++;
            }

            if (maxReach == covered) {
                System.out.println(0);
                return;
            }

            covered = maxReach;
            cnt++;
        }
		
		System.out.println(cnt);
	}
	
	
}
