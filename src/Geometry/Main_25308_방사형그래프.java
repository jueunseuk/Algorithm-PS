package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25308_방사형그래프 {
    static final int N = 8;
    static double[] dist = new double[N];
    static boolean[] used = new boolean[N]; 
    static double[] perm = new double[N];
    static int count = 0;
    
    static double[] angles = new double[N];
    static {
        for(int i=0; i<N; i++) {
            angles[i] = 2.0 * Math.PI * i / N;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N; i++) {
            dist[i] = Double.parseDouble(st.nextToken());
        }
        
        backtrack(0);
        
        System.out.println(count);
    }
    
    static void backtrack(int depth) {
        if(depth == N) {
            if(isCvx()) {
                count++;
            }
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!used[i]) {
                used[i] = true;
                perm[depth] = dist[i];
                backtrack(depth+1);
                used[i] = false;
            }
        }
    }
    
    static boolean isCvx() {
        double[][] points = new double[N][2];
        
        for(int i=0; i<N; i++) {
            double r = perm[i];
            double theta = angles[i];
            double x = r * Math.cos(theta);
            double y = r * Math.sin(theta);
            points[i][0] = x;
            points[i][1] = y;
        }
        
        double prev = 0.0; 
        for(int i = 0; i < N; i++) {
            int i1 = i;
            int i2 = (i+1) % N;
            int i3 = (i+2) % N;
            
            double cp = cross(points[i1][0], points[i1][1], points[i2][0], points[i2][1], points[i3][0], points[i3][1]);
            
            if (Math.abs(cp) < 1e-12) { 
                return false; 
            }
            
            if (prev == 0.0) {
                prev = cp;
            } else {
                if (cp * prev < 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static double cross(double x1, double y1, double x2, double y2, double x3, double y3) {
        return (x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1);
    }
}
