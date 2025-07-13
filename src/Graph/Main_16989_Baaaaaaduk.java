package Graph;
import java.io.*;
import java.util.*;

public class Main_16989_Baaaaaaduk {
    static int row, col;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] parent;
    static int[] size;

    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        if(size[a] < size[b]) {
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        
        for (int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int totalCells = row * col;
        parent = new int[totalCells];
        size = new int[totalCells];
        for (int i = 0; i < totalCells; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 2) {
                    int id = i * col + j;
                    for (int d = 0; d < 4; d++){
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || nj < 0 || ni >= row || nj >= col) continue;
                        if (board[ni][nj] == 2) {
                            int nid = ni * col + nj;
                            union(id, nid);
                        }
                    }
                }
            }
        }
        
        class GroupInfo {
            int stoneCount;
            HashSet<Integer> liberties;
            GroupInfo() {
                stoneCount = 0;
                liberties = new HashSet<>();
            }
        }
        HashMap<Integer, GroupInfo> groups = new HashMap<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 2) {
                    int id = i * col + j;
                    int root = find(id);
                    groups.putIfAbsent(root, new GroupInfo());
                    GroupInfo gi = groups.get(root);
                    gi.stoneCount++;
                    for (int d = 0; d < 4; d++){
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || nj < 0 || ni >= row || nj >= col) continue;
                        if (board[ni][nj] == 0) {
                            int lib = ni * col + nj;
                            gi.liberties.add(lib);
                        }
                    }
                }
            }
        }
        
        HashMap<Integer, Integer> oneLibMap = new HashMap<>();
        HashMap<Long, Integer> twoLibMap = new HashMap<>();
        HashSet<Integer> candidateSet = new HashSet<>();
        
        for (GroupInfo gi : groups.values()){
            if (gi.liberties.size() > 2) continue;
            if (gi.liberties.size() == 1) {
                int cand = gi.liberties.iterator().next();
                oneLibMap.put(cand, oneLibMap.getOrDefault(cand, 0) + gi.stoneCount);
                candidateSet.add(cand);
            } else if (gi.liberties.size() == 2) {
                List<Integer> libs = new ArrayList<>(gi.liberties);
                int a = libs.get(0), b = libs.get(1);
                if(a > b) { int tmp = a; a = b; b = tmp; }
                long key = (((long) a) << 32) | (b & 0xffffffffL);
                twoLibMap.put(key, twoLibMap.getOrDefault(key, 0) + gi.stoneCount);
                candidateSet.add(a);
                candidateSet.add(b);
            }
        }
        
        int ans = 0;
        List<Integer> candidates = new ArrayList<>(candidateSet);
        
        if(candidates.size() >= 2) {
            int max1 = 0, max2 = 0;
            for (int cand : candidates) {
                int val = oneLibMap.getOrDefault(cand, 0);
                if(val > max1) {
                    max2 = max1;
                    max1 = val;
                } else if(val > max2) {
                    max2 = val;
                }
            }
            ans = Math.max(ans, max1 + max2);
        } else if(candidates.size() == 1) {
            ans = Math.max(ans, oneLibMap.getOrDefault(candidates.get(0), 0));
        }
        
        for (Map.Entry<Long, Integer> entry : twoLibMap.entrySet()){
            long key = entry.getKey();
            int a = (int)(key >> 32);
            int b = (int) key;
            int sum = oneLibMap.getOrDefault(a, 0) + oneLibMap.getOrDefault(b, 0) + entry.getValue();
            ans = Math.max(ans, sum);
        }
        
        System.out.println(ans);
    }
}