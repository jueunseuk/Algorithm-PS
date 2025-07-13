package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] lectures = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 시작 시간/종료 시간 각각 정렬
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];
        for (int i = 0; i < N; i++) {
            startTimes[i] = lectures[i][0];
            endTimes[i] = lectures[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int startPointer = 0, endPointer = 0;
        int roomsNeeded = 0, maxRooms = 0;
        
        // 두 포인터를 사용하여 필요한 강의실 수 계산
        // 
        while (startPointer < N) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                roomsNeeded++;
                startPointer++;
            } else {
                roomsNeeded--;
                endPointer++;
            }
            maxRooms = Math.max(maxRooms, roomsNeeded);
        }
        
        System.out.println(maxRooms);
    }
}
