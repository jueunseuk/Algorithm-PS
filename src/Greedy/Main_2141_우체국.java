package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2141_우체국 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Village> villages = new ArrayList<>();
        
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            villages.add(new Village(x, p));
            sum += p;
        }
        
        Collections.sort(villages, new Comparator<Village>() {
			@Override
			public int compare(Village o1, Village o2) {
				return o1.x - o2.x;
			}
        });
        
        long current = 0;
        for (Village village : villages) {
        	current += village.p;
            if (current >= (sum+1) / 2) {
                System.out.println(village.x);
                break;
            }
        }
    }
    
}

class Village {
	int x;
	int p;
	
	Village(int x, int p) {
		this.x = x;
		this.p = p;
	}
}
