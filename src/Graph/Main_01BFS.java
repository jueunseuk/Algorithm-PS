package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_01BFS {
    static final int INF = 100_000_000;

    static int node, edge;
    static List<List<int[]>> list = new ArrayList<>(); // 인접 리스트
    static int[] bfsCost;      // 0-1 BFS 결과
    static int[] dijkCost;     // 다익스트라 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드, 간선 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        for (int i = 0; i <= node; i++) list.add(new ArrayList<>());

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());
            int w     = Integer.parseInt(st.nextToken()); // 0 또는 1

            list.get(start).add(new int[]{end, w});
            list.get(end).add(new int[]{start, w});
        }

        /*--------------------- 0-1 BFS ---------------------*/
        long t0 = System.nanoTime();
        zeroOneBFS(1);
        long bfsTime = System.nanoTime() - t0;

        /*------------------- 다익스트라 --------------------*/
        t0 = System.nanoTime();
        dijkstra(1);
        long dijkTime = System.nanoTime() - t0;

        /*-------------------- 결과 출력 --------------------*/
        System.out.printf("0-1 BFS   : %.3f ms%n", bfsTime / 1_000_000.0);
        System.out.printf("Dijkstra : %.3f ms%n", dijkTime / 1_000_000.0);
        System.out.println();

        for (int i = 1; i <= node; i++) {
            System.out.printf("1 → %d  |  0-1 BFS = %d,  Dijkstra = %d%n",
                              i, bfsCost[i], dijkCost[i]);
        }
    }

    /*--------------- 0-1 너비 우선 탐색 ---------------*/
    private static void zeroOneBFS(int start) {
        Deque<int[]> dq = new ArrayDeque<>();
        bfsCost = new int[node + 1];
        Arrays.fill(bfsCost, INF);

        dq.offerFirst(new int[]{start, 0});
        bfsCost[start] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int u = cur[0], dist = cur[1];

            if (dist != bfsCost[u]) continue; // 최신 거리 아니면 skip

            for (int[] nx : list.get(u)) {
                int v = nx[0], w = nx[1];
                int nd = dist + w;
                if (bfsCost[v] > nd) {
                    bfsCost[v] = nd;
                    if (w == 0) dq.offerFirst(new int[]{v, nd});
                    else        dq.offerLast (new int[]{v, nd});
                }
            }
        }
    }

    /*------------------- 다익스트라 -------------------*/
    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dijkCost = new int[node + 1];
        Arrays.fill(dijkCost, INF);

        pq.offer(new int[]{start, 0});
        dijkCost[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], dist = cur[1];

            if (dist != dijkCost[u]) continue; // 최신 거리 아니면 skip

            for (int[] nx : list.get(u)) {
                int v = nx[0], w = nx[1];
                int nd = dist + w;
                if (dijkCost[v] > nd) {
                    dijkCost[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
    }
}
