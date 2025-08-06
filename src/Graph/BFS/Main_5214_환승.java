package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_5214_환승 {
    static int N, K, M;
    static List<int[]> tubeStations;
    static List<List<Integer>> stationToTubes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tubeStations = new ArrayList<>(M + 1);
        stationToTubes = new ArrayList<>(N + 1);
        tubeStations.add(null);
        for (int i = 0; i <= N; i++) stationToTubes.add(new ArrayList<>());

        for (int t = 1; t <= M; t++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[K];
            for (int j = 0; j < K; j++) {
                int v = Integer.parseInt(st.nextToken());
                arr[j] = v;
                stationToTubes.get(v).add(t);
            }
            tubeStations.add(arr);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visitedStation = new boolean[N + 1];
        boolean[] visitedTube    = new boolean[M + 1];

        q.offer(new int[]{1, 1});
        visitedStation[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int station = cur[0];
            int depth   = cur[1];
            if (station == N) return depth;

            for (int tube : stationToTubes.get(station)) {
                if (visitedTube[tube]) continue;
                visitedTube[tube] = true;

                for (int next : tubeStations.get(tube)) {
                    if (visitedStation[next]) continue;
                    visitedStation[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }
        return -1;
    }
}