package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main_11909_배열탈출 {
    static int[][] arr;
    static int[][] minMoney;
    static int n;
    static final int INF = 10000000;
    
    static boolean inRange(int x, int y) {
        return (x >= 1 && x <= n && y >= 1 && y <= n);
    }
    
    static void initialization() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                minMoney[i][j] = INF;
            }
        }
    }
    
    static void dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, startX, startY));
        minMoney[startX][startY] = 0;
        
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x;
            int y = current.y;
            int money = current.cost;
            
            if (money > minMoney[x][y])
                continue;
            
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!inRange(nx, ny)) continue;
                
                int nextMoney = money;
                
                if (arr[nx][ny] >= arr[x][y]) {
                    nextMoney += (arr[nx][ny] - arr[x][y] + 1);
                }
                if (nextMoney < minMoney[nx][ny]) {
                    minMoney[nx][ny] = nextMoney;
                    pq.offer(new Node(nextMoney, nx, ny));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        minMoney = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initialization();
        dijkstra(1, 1);
        
        System.out.println(minMoney[n][n]);
    }
    
    static class Node implements Comparable<Node> {
        int cost, x, y;
        public Node(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}
