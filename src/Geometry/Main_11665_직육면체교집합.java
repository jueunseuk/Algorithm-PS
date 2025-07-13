package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11665_직육면체교집합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int minX = Integer.parseInt(st.nextToken());
        int minY = Integer.parseInt(st.nextToken());
        int minZ = Integer.parseInt(st.nextToken());
        int maxX = Integer.parseInt(st.nextToken());
        int maxY = Integer.parseInt(st.nextToken());
        int maxZ = Integer.parseInt(st.nextToken());
        
        if (n == 1) {
            System.out.println((maxX - minX) * (maxY - minY) * (maxZ - minZ));
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int nx1 = Integer.parseInt(st.nextToken());
            int ny1 = Integer.parseInt(st.nextToken());
            int nz1 = Integer.parseInt(st.nextToken());
            int nx2 = Integer.parseInt(st.nextToken());
            int ny2 = Integer.parseInt(st.nextToken());
            int nz2 = Integer.parseInt(st.nextToken());

            if (nx1 > nx2) { int temp = nx1; nx1 = nx2; nx2 = temp; }
            if (ny1 > ny2) { int temp = ny1; ny1 = ny2; ny2 = temp; }
            if (nz1 > nz2) { int temp = nz1; nz1 = nz2; nz2 = temp; }
            
            if (nx2 <= minX || nx1 >= maxX || ny2 <= minY || ny1 >= maxY || nz2 <= minZ || nz1 >= maxZ) {
                System.out.println(0);
                return;
            }
            
            minX = Math.max(minX, nx1);
            maxX = Math.min(maxX, nx2);
            minY = Math.max(minY, ny1);
            maxY = Math.min(maxY, ny2);
            minZ = Math.max(minZ, nz1);
            maxZ = Math.min(maxZ, nz2);

            if (minX >= maxX || minY >= maxY || minZ >= maxZ) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println((maxX - minX) * (maxY - minY) * (maxZ - minZ));
    }
}
