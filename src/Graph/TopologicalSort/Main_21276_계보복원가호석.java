package Graph.TopologicalSort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21276_계보복원가호석 {
    static int N, M;
    static Map<String, Integer> id = new HashMap<>();
    static String[] name;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] indeg;
    static List<List<Integer>> child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        name = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            name[i] = st.nextToken();
        }
        Arrays.sort(name);
        for (int i = 0; i < N; i++) id.put(name[i], i);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }
        indeg = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int childIdx   = id.get(st.nextToken());
            int parentIdx  = id.get(st.nextToken());
            g.get(parentIdx).add(childIdx);
            indeg[childIdx]++;
        }

        child = new ArrayList<>();
        for (int i = 0; i < N; i++) child.add(new ArrayList<>());

        topoAndBuild();

        List<String> roots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	if (indeg[i] == 0) roots.add(name[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roots.size()).append('\n');
        for (String r : roots) {
        	sb.append(r).append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append('\n');

        for (int i = 0; i < N; i++) {
            List<Integer> cList = child.get(i);
            Collections.sort(cList);

            sb.append(name[i]).append(' ').append(cList.size());

            for (int idx : cList) {
                sb.append(' ').append(name[idx]);
            }
            sb.append('\n');
        }
        
        System.out.print(sb.toString());
    }

    private static void topoAndBuild() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) if (indeg[i] == 0) q.add(i);

        int[] indegCopy = indeg.clone();
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int c : g.get(p)) {
                if (--indeg[c] == 0) {
                    child.get(p).add(c);
                    q.add(c);
                }
            }
        }
        indeg = indegCopy;
    }
}