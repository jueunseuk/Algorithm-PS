package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_19638_센티와마법의뿅망치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        int t = Integer.parseInt(line[2]);
        int cnt = 0;
        boolean isPossible = true;

        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        while((n--) > 0){
            int a = Integer.parseInt(br.readLine());
            if(a >= h) {
                list.add(a);
                isPossible = false;
            }
        }

        for(int i = 0 ; i < t && list.size() != 0; i++){
            int a = list.poll();
            if(a != 1) {
                a /= 2;
            }
            if(a >= h){
                list.add(a);
            }
            if(list.size() == 0){
                isPossible = true;
                cnt = i+1;
                break;
            }
        }

        if(isPossible){
            System.out.println("YES");
            System.out.println(cnt);
        }else{
            System.out.println("No");
            System.out.println(list.peek());
        }
    }
}
