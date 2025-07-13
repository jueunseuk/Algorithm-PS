package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_32195_야구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ball = Integer.parseInt(br.readLine());
        double[] distances = new double[ball];
        int[][] positions = new int[ball][2];
        
        // 타구의 좌표 입력 및 거리 계산
        for (int i = 0; i < ball; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i][0] = x;
            positions[i][1] = y;
            distances[i] = getDistance(x, y); // 거리 계산
        }
        
        int fence = Integer.parseInt(br.readLine());
        int[] fenceDistance = new int[fence];
        
        // 담장까지의 거리 입력
        for (int i = 0; i < fence; i++) {
            fenceDistance[i] = Integer.parseInt(br.readLine());
        }
        
        // 각 담장 거리 후보에 대해 결과 계산
        for (int i = 0; i < fence; i++) {
            int R = fenceDistance[i];
            int foul = 0, inField = 0, homeRun = 0;
            
            // 각 타구를 확인하여 분류
            for (int j = 0; j < ball; j++) {
                int x = positions[j][0];
                int y = positions[j][1];
                double distance = distances[j];
                
                // 파울, 내야, 홈런 구분
                if (y < x || y < -x) {
                    foul++; // 부채꼴 영역 밖인 경우 파울
                } else if (distance <= R) {
                    inField++; // 부채꼴 영역 안쪽이면서 담장 거리 내인 경우 내야
                } else {
                    homeRun++; // 부채꼴 영역 안쪽이지만 담장 거리 밖인 경우 홈런
                }
            }
            
            // 결과 출력
            System.out.println(foul + " " + inField + " " + homeRun);
        }
    }
    
    // 거리 계산 함수
    public static double getDistance(int x, int y) {
        return Math.sqrt((long) x * x + (long) y * y); // long으로 형변환하여 오버플로 방지
    }
}
