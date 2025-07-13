package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_30827_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] meetings = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		meetings[i][0] = Integer.parseInt(st.nextToken());
    		meetings[i][1] = Integer.parseInt(st.nextToken())+1;
        }
        
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        int count = 0;
        int endTime = 0;
        
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                count++;
            }
        }
        
        System.out.println(count);
    }
}
