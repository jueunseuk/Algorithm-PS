package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_29814_원교수님과제가너무많아요 {
    static int[] parent;

    static int find(int x) {
        if(parent[x] < 0) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a != b) {
            parent[a] = b;
        }
    }

    static class Assign {
        int latestStart;
        int point;

        public Assign(int latestStart, int point) {
            this.latestStart = latestStart;
            this.point = point;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        Assign[] assigns = new Assign[n];
        int maxDay = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int latestStart = d - t + 1;
            if(latestStart < 1){
                latestStart = 1;
            }
            assigns[i] = new Assign(latestStart, p);
            if(d > maxDay){
                maxDay = d;
            }
        }

        Arrays.sort(assigns, new Comparator<Assign>() {
            @Override
            public int compare(Assign a1, Assign a2) {
                if(a2.point != a1.point){
                    return a2.point - a1.point;
                }
                return a2.latestStart - a1.latestStart;
            }
        });

        parent = new int[maxDay + 2];
        Arrays.fill(parent, -1);

        long sum = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            Assign assign = assigns[i];
            int day = find(assign.latestStart);
            if(day > 0){
                sum += assign.point;
                cnt++;
                union(day, day - 1);
                if(sum >= C){
                    System.out.println(cnt);
                    return;
                }
            }
        }

        System.out.println("I'm sorry professor Won!");
    }
}
