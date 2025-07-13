package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16287_Parcel {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        Pair[] visited = new Pair[w+1];
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int val = arr[i] + arr[j];
                if(val > w) {
                    break;
                }
                visited[val] = new Pair(i, j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int val = arr[i] + arr[j];
                if(val > w) {
                    break;
                }
                int need = w - val;
                if(need >= 0) {
                    if(visited[need] != null) {
                        Pair p = visited[need];
                        if(p.x != i && p.x != j && p.y != i && p.y != j) {
                            System.out.println("YES");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("NO");
    }
}
