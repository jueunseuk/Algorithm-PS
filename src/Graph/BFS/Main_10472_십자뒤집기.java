package Graph.BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10472_십자뒤집기 {
    static int size = 3;
    static int target;
    static int[] flipMask = new int[9];

    public static void main(String[] args) throws Exception {
        Reader rd = new Reader();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int idx = i * size + j;
                int mask = 0;
                mask |= 1 << idx;
                if (i > 0) mask |= 1 << ((i - 1) * size + j);
                if (i < 2) mask |= 1 << ((i + 1) * size + j);
                if (j > 0) mask |= 1 << (i * size + (j - 1));
                if (j < 2) mask |= 1 << (i * size + (j + 1));
                flipMask[idx] = mask;
            }
        }

        int T = rd.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            target = 0;
            for (int i = 0; i < 9; i++) {
                char c = rd.nextChar();
                if (c == '*') target |= 1 << i;
            }
            
            sb.append(bfs()).append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[1 << 9];

        q.offer(new int[] {0, 0});
        visit[0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int state = poll[0], depth = poll[1];

            if (state == target) return depth;

            for (int i = 0; i < 9; i++) {
                int next = state ^ flipMask[i];
                if (!visit[next]) {
                    visit[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }
        
        return -1;
    }

    static class Reader {
        private final int SIZE = 1 << 13;
        private final byte[] buffer = new byte[SIZE];
        private int index, size;

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = n * 10 + (c - '0');
            while ((c = read()) > 32);
            return n;
        }

        char nextChar() throws IOException {
            byte c;
            while ((c = read()) <= 32);
            return (char) c;
        }

        private byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) return -1;
            }
            return buffer[index++];
        }
    }
}
