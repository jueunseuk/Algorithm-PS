package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1202_보석도둑 {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Jewel jewel[] = new Jewel[n];
        int bag[] = new int[k];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	jewel[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewel, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o1.weight - o2.weight;
			}
        });
        
        for(int i = 0; i < k; i++) {
        	bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        
        long result = 0;
        int idx = 0; // jewel's idx
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++) {
        	while (idx < n && jewel[idx].weight <= bag[i]) {
                q.offer(jewel[idx++].price);
            }
        	
        	if (!q.isEmpty()) {
                result += q.poll();
            }
        }
        
        System.out.println(result);
        
	}

}

class Jewel {
	int weight;
	int price;
	
	public Jewel(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
}