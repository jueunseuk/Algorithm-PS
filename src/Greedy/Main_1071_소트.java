package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_1071_소트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        int prev = -2;

        while (!map.isEmpty()) {
            boolean added = false;

            for (int key : map.keySet()) {
                if (prev + 1 == key) {
                    continue;
                }

                result.append(key).append(" ");
                prev = key;
                map.put(key, map.get(key) - 1);

                if (map.get(key) == 0) {
                    map.remove(key);
                }

                added = true;
                break;
            }

            if (!added) {
                prev = -2;
            }
        }

        System.out.println(result.toString().trim());
    }
}
