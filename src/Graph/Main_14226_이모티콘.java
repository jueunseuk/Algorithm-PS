package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_14226_이모티콘 {
    static boolean[][] visit = new boolean[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int s = Integer.parseInt(br.readLine());

        System.out.println(bfs(s));
    }

    private static int bfs(int s) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{1, 0, 0});
        visit[1][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int scr = curr[0];
            int clip = curr[1];
            int time = curr[2];

            if (scr == s) {
                return time;
            }

            if (!visit[scr][scr]) {
            	visit[scr][scr] = true;
                q.offer(new int[]{scr, scr, time+1});
            }

            if (clip > 0 && scr + clip < 1001) {
                if (!visit[scr + clip][clip]) {
                	visit[scr + clip][clip] = true;
                    q.offer(new int[]{scr+clip, clip, time+1});
                }
            }

            if (scr - 1 >= 0) {
                if (!visit[scr-1][clip]) {
                	visit[scr-1][clip] = true;
                    q.offer(new int[]{scr-1, clip, time+1});
                }
            }
        }
        
        return -1;
    }
}
