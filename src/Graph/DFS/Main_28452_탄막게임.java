package Graph.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_28452_탄막게임 {
    static int N, M, T;
    static int startX, startY;
    static HashSet<State> memo = new HashSet<>();
    
    static int[] dxs = {-1,-1,-1, 0,0, 0, 1,1,1};
    static int[] dys = {-1, 0, 1, -1,0, 1, -1,0,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine().trim());
        BitSet initBullets = new BitSet(N * M);
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            initBullets.set(bx * M + by);
        }
        
        if(T == 0){
            System.out.println("YES");
            return;
        }
        
        memo.clear();
        boolean res = dfs(0, startX, startY, initBullets);
        System.out.println(res ? "YES" : "NO");
    }
    
    static boolean dfs(int t, int cx, int cy, BitSet bullets) {
        if(t == T) {
            return true;
        }
        
        State curState = new State(t, cx, cy, bullets);
        if(memo.contains(curState))
            return false;
        
        for(int i = 0; i < 9; i++){
            int ncx = cx + dxs[i];
            int ncy = cy + dys[i];
            
            if(ncx < 0 || ncx >= N || ncy < 0 || ncy >= M) continue;
            
            boolean safe = true;
            for(int a = ncx - 1; a <= ncx + 1 && safe; a++){
                if(a < 0 || a >= N) continue;
                for(int b = ncy - 1; b <= ncy + 1; b++){
                    if(b < 0 || b >= M) continue;
                    if(bullets.get(a * M + b)){
                        safe = false;
                        break;
                    }
                }
            }
            if(!safe) continue;
            
            BitSet newBullets = new BitSet(N * M);
            for(int pos = bullets.nextSetBit(0); pos >= 0; pos = bullets.nextSetBit(pos+1)){
                int bx = pos / M;
                int by = pos % M;
                int stepX = Integer.compare(ncx, bx);
                int stepY = Integer.compare(ncy, by);
                int nbx = bx + stepX;
                int nby = by + stepY;
                newBullets.set(nbx * M + nby);
            }
            
            if(dfs(t + 1, ncx, ncy, newBullets))
                return true;
        }
        
        memo.add(curState);
        return false;
    }
    
    static class State {
        int t, cx, cy;
        BitSet bullets;
        int hash;
        
        State(int t, int cx, int cy, BitSet bullets) {
            this.t = t;
            this.cx = cx;
            this.cy = cy;
            this.bullets = (BitSet) bullets.clone();
            hash = computeHash();
        }
        
        private int computeHash(){
            int result = 17;
            result = 31 * result + t;
            result = 31 * result + cx;
            result = 31 * result + cy;
            result = 31 * result + bullets.hashCode();
            return result;
        }
        
        @Override
        public int hashCode(){
            return hash;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof State)) return false;
            State other = (State) o;
            if(this.t != other.t || this.cx != other.cx || this.cy != other.cy)
                return false;
            return this.bullets.equals(other.bullets);
        }
    }
}
