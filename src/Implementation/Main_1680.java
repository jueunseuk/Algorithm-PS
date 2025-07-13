package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1680 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int capacity = Integer.parseInt(st.nextToken()); // 트럭의 최대 적재량
            int n = Integer.parseInt(st.nextToken()); // 구간의 수

            int[][] arr = new int[n][2]; // 구간 거리와 쓰레기 양을 저장하는 배열
            
            // 입력된 구간의 거리와 쓰레기 양을 배열에 저장
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 거리
                arr[i][1] = Integer.parseInt(st.nextToken()); // 쓰레기 양
            }

            int totalDistance = 0; // 총 이동 거리
            int currentLoad = 0; // 현재 적재된 쓰레기 양
            int lastPosition = 0; // 마지막 위치 추적

            // 각 구간을 순회하면서 적재량을 초과하지 않도록 처리
            for (int i = 0; i < n; i++) {
                if (currentLoad + arr[i][1] > capacity) { // 적재량 초과 시
                    totalDistance += 2 * arr[i][0]; // 왕복 거리 추가
                    currentLoad = arr[i][1]; // 현재 구간의 쓰레기만 적재
                    lastPosition = arr[i][0]; // 마지막 위치 갱신
                } else {
                    currentLoad += arr[i][1]; // 현재 트럭에 쓰레기 적재
                    lastPosition = arr[i][0]; // 마지막 위치 갱신
                }

                // 적재량이 정확히 채워지면 바로 처리
                if (currentLoad == capacity) {
                    totalDistance += 2 * lastPosition;
                    currentLoad = 0; // 트럭을 비운 상태로 리셋
                    lastPosition = 0;
                }
            }

            // 남은 쓰레기를 처리하는 거리 추가
            if (currentLoad > 0) {
                totalDistance += 2 * lastPosition;
            }

            System.out.println(totalDistance); // 결과 출력
        }
    }
}
