package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Section[] sec = new Section[6];
        int temp[] = new int[5];
        
        StringTokenizer st;
        for(int i = 0; i < 6; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int direction = Integer.parseInt(st.nextToken());
        	int length = Integer.parseInt(st.nextToken());
        	
        	sec[i] = new Section(i, direction, length);
        	temp[direction]++;
        }
        
        boolean check[] = new boolean[6];
        for(int i = 0; i < 6; i++) {
        	if(temp[sec[i].direction] == 2) {
        		check[i] = true;
        	}
        }
        
        int answer = 0;
        
        if(!check[0] && !check[1]) {
            int smallRect = sec[3].length * sec[4].length;
            int bigRect = sec[0].length * sec[1].length;
            answer = (bigRect - smallRect) * n;
        } else if(!check[1] && !check[2]) {
            int smallRect = sec[4].length * sec[5].length;
            int bigRect = sec[1].length * sec[2].length;
            answer = (bigRect - smallRect) * n;
        } else if(!check[2] && !check[3]) {
            int smallRect = sec[5].length * sec[0].length;
            int bigRect = sec[2].length * sec[3].length;
            answer = (bigRect - smallRect) * n;
        } else if(!check[3] && !check[4]) {
            int smallRect = sec[0].length * sec[1].length;
            int bigRect = sec[3].length * sec[4].length;
            answer = (bigRect - smallRect) * n;
        } else if(!check[4] && !check[5]) {
            int smallRect = sec[1].length * sec[2].length;
            int bigRect = sec[4].length * sec[5].length;
            answer = (bigRect - smallRect) * n;
        } else if(!check[5] && !check[0]) {
            int smallRect = sec[2].length * sec[3].length;
            int bigRect = sec[5].length * sec[0].length;
            answer = (bigRect - smallRect) * n;
        }
        
        System.out.println(answer);
	}
	
	public static class Section {
		int idx;
		int direction;
		int length;
		
		public Section (int idx, int direction, int length) {
			this.idx = idx;
			this.direction = direction;
			this.length = length;
		}
	}

}
