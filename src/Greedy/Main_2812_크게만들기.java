package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {
    static PriorityQueue<Integer>[] number = new PriorityQueue[10];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String s = br.readLine();
        
        for(int d = 0; d < 10; d++){
            number[d] = new PriorityQueue<>();
        }
        
        for(int i = 0; i < N; i++){
            int digit = s.charAt(i) - '0';
            number[digit].offer(i);
        }
        
        int length = N - K;
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        for(int pos = 0; pos < length; pos++){
            int end = N - (length - pos);
            for(int d = 9; d >= 0; d--){
                while(!number[d].isEmpty() && number[d].peek() < start){
                    number[d].poll();
                }
                if(!number[d].isEmpty() && number[d].peek() <= end){
                    int idx = number[d].poll();
                    sb.append(d);
                    start = idx + 1;
                    break;
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}
