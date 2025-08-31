package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	static boolean matrix[][];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<Integer, int[]> map = new HashMap<>();
        
        StringTokenizer st;
        for(int i = 0; i < 5; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < 5; j++) {
        		map.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
        	}
        }
        
        matrix = new boolean[5][5];
        
        int cnt = 1;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int[] pos = map.get(Integer.parseInt(st.nextToken()));
                matrix[pos[0]][pos[1]] = true;

                if (bingoCount() >= 3) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
        }
	}

	private static int bingoCount() {
	    int count = 0;

	    for (int i = 0; i < 5; i++) {
	        boolean ok = true;
	        for (int j = 0; j < 5; j++) if (!matrix[i][j]) { ok = false; break; }
	        if (ok) count++;
	    }

	    for (int j = 0; j < 5; j++) {
	        boolean ok = true;
	        for (int i = 0; i < 5; i++) if (!matrix[i][j]) { ok = false; break; }
	        if (ok) count++;
	    }

	    boolean ok = true;
	    for (int i = 0; i < 5; i++) if (!matrix[i][i]) { ok = false; break; }
	    if (ok) count++;

	    ok = true;
	    for (int i = 0; i < 5; i++) if (!matrix[i][4 - i]) { ok = false; break; }
	    if (ok) count++;

	    return count;
	}
}