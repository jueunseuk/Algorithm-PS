package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (command.equals("D")) {
                    if (map.isEmpty()) continue;

                    int key = (value == 1) ? map.lastKey() : map.firstKey();
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }

            if (map.isEmpty()) {
                result.append("EMPTY").append("\n");
            } else {
                result.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(result.toString().trim());
    }
}
