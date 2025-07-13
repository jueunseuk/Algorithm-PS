package TwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15831_준표의조약돌 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int maxB = Integer.parseInt(st.nextToken());
        int minW = Integer.parseInt(st.nextToken());
        
        char[] road = br.readLine().toCharArray();
        
        int maxLen = 0;
        int left = 0, right = 0;
        int blackCnt = 0, whiteCnt = 0;

        while (right < n) {
            if (road[right] == 'W') {
            	whiteCnt++;
            } else {
            	blackCnt++;
            }

            while (blackCnt > maxB) {
                if (road[left] == 'B') blackCnt--;
                else whiteCnt--;
                left++;
            }

            int length = right - left + 1;
            if (whiteCnt >= minW) {
                maxLen = Math.max(maxLen, length);
            }

            right++;
        }

        System.out.println(maxLen);
	}

}
