package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24313_알고리즘수업점근적표기법1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
    
        if((a1*n0+a0) <= c*n0 && a1 <= c){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}