package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2457_공주님의정원 {
	static int[] sm = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int input[][] = new int[n][2];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	input[i][0] = sm[Integer.parseInt(st.nextToken())] + Integer.parseInt(st.nextToken());
        	input[i][1] = sm[Integer.parseInt(st.nextToken())] + Integer.parseInt(st.nextToken())-1;
        }
        
        Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				return o1[0]-o2[0];
			}
        });
        
        int coverage = 60;
        int idx = 0;
        int count = 0;
        int need = 0;

        while (coverage <= 334) {
            boolean found = false;
            
            int curr = need;
            while (idx < n && input[idx][0] <= coverage) {
            	curr = Math.max(curr, input[idx][1]);
                idx++;
                found = true;
            }

            if (!found) {
                System.out.println(0);
                return;
            }
            
            coverage = curr + 1;
            count++;

            if (coverage > 334) {
                break;
            }
        }
        
        System.out.println(count);
	}

}
