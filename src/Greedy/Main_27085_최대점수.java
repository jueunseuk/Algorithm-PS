package Greedy;
import java.io.*;
import java.util.*;

public class Main_27085_최대점수 {
    static int N;
    static int s;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        long[] dungeon = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dungeon[i] = Long.parseLong(st.nextToken());
        }

        int idxL = s - 1;
        int idxR = s - 1;
        long currL = 0;
        long currR = 0;

        while (true) {
        	idxR = moveRight(idxR, currR, dungeon);
        	currR = max;
            idxL = moveLeft(idxL, currL, dungeon);
            currL = max;
            if (max == currR) break;
        }

        System.out.println(max);
    }

    public static int moveRight(int cursor, long beforeMax, long[] arr) {
        if (cursor >= N) return cursor;
        
        long v = max - beforeMax + arr[cursor];
        
        cursor++;
        while (cursor < N) {
            if (v + arr[cursor] < 0) return cursor - 1;
            
            arr[cursor] += v;
            v = arr[cursor];
            
            max = Math.max(max, v);
            cursor++;
        }
        
        return cursor;
    }

    public static int moveLeft(int cursor, long beforeMax, long[] arr) {
        if (cursor < 0) return cursor;
        
        long v = max - beforeMax + arr[cursor];
        
        cursor--;
        while (cursor >= 0) {
            if (v + arr[cursor] < 0) return cursor + 1;
            
            arr[cursor] += v;
            v = arr[cursor];
            
            max = Math.max(max, v);
            cursor--;
        }
        
        return cursor;
    }
}
