package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main_30410_접시포개기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 접시의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄: 접시의 두께들을 공백으로 구분하여 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두께별 접시 개수를 저장할 맵 (TreeMap을 사용하여 정렬된 키 관리)
        Map<Integer, Integer> thicknessCount = new HashMap<>();

        int maxThickness = 0;

        for(int i = 0; i < N; i++) {
            int thickness = Integer.parseInt(st.nextToken());
            thicknessCount.put(thickness, thicknessCount.getOrDefault(thickness, 0) +1);
            if(thickness > maxThickness) {
                maxThickness = thickness;
            }
        }

        // 정렬된 두께를 관리하기 위해 TreeSet 사용
        TreeSet<Integer> sortedThick = new TreeSet<>(thicknessCount.keySet());

        // 포개기 수행
        for(int t : sortedThick) {
            while(thicknessCount.getOrDefault(t,0) >=2) {
                int pairs = thicknessCount.get(t) /2;
                thicknessCount.put(t, thicknessCount.get(t) %2);

                int newThickness = t *2;
                thicknessCount.put(newThickness, thicknessCount.getOrDefault(newThickness,0) + pairs);
                if(newThickness > maxThickness) {
                    maxThickness = newThickness;
                }
                // 새로 추가된 두께를 정렬된 집합에 추가
                sortedThick.add(newThickness);
            }
        }

        // 최종적으로 가장 큰 두께 출력
        System.out.println(maxThickness);
    }
}
