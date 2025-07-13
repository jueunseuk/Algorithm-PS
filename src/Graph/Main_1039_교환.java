package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1039_교환 {
	static final int MAX = 1000000;
	
	static int n, k, length = 0, max = 0;
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		int temp = n;
		while(temp > 0) {
			temp /= 10;
			length++;
		}
		
		if(length == 1) {
			System.out.println(-1);
			return;
		}
		
		visit = new boolean[MAX+1][k+1];
		
		bfs();
		
		System.out.println(max == 0 ? -1 : max);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {n, 0});
		visit[n][0] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] == k) {
				max = Math.max(max, poll[0]);
				continue;
			}
			
			char[] number = String.valueOf(poll[0]).toCharArray();
			for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int next = swap(i, j, number);
                    if (next == -1) continue;

                    if (!visit[next][poll[1] + 1]) {
                        visit[next][poll[1] + 1] = true;
                        q.offer(new int[] { next, poll[1] + 1 });
                    }
                }
            }
		}
	}

	private static int swap(int i, int j, char[] arr) {
        char[] copy = arr.clone();
        char t = copy[i];
        copy[i] = copy[j];
        copy[j] = t;

        if (copy[0] == '0') return -1;

        int res = 0;
        for (char c : copy) res = res * 10 + (c - '0');
        return res;
    }
}
