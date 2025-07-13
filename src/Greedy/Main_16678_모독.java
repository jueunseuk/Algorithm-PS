package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_16678_모독 {
	static List<Integer> list;

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
        	list.add(Integer.parseInt(br.readLine()));
        }
        
        br.close();

        Collections.sort(list);
        
        long cost = 0;
        long decrease = 0;
        
        while (!list.isEmpty()) {
            long val = list.get(0) - decrease;
            if (val <= 0) {
                list.remove(0);
            } else if (val == 1) {
            	decrease++;
                while(!list.isEmpty() && list.get(0) - decrease <= 0) {
                    list.remove(0);
                }
            } else {
                long diff = val - 1;
                cost += diff;
                list.set(0, (int)(list.get(0) - diff));
            }
        }
        
        System.out.println(cost);
	}

}
