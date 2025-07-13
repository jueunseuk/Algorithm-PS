package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1004_어린왕자 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        Set<Integer> start;
        Set<Integer> end;
        Set<Integer> inter;
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int startX = Integer.parseInt(st.nextToken());
        	int startY = Integer.parseInt(st.nextToken());
        	int endX = Integer.parseInt(st.nextToken());
        	int endY = Integer.parseInt(st.nextToken());
        	
        	start = new HashSet<>();
        	end = new HashSet<>();
        	
        	int circle = Integer.parseInt(br.readLine());
        	
        	for(int i = 0; i < circle; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		int r = Integer.parseInt(st.nextToken());
        		
        		if(calculator(startX, startY, x, y) <= r*r) {
        			start.add(i);
        		}
        		if(calculator(endX, endY, x, y) <= r*r) {
        			end.add(i);
        		}
        	}
        	
        	inter = new HashSet<>(start);
        	inter.retainAll(end);
        	
        	start.removeAll(inter);
        	end.removeAll(inter);
        	
        	sb.append(start.size()+end.size()).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
	
	public static int calculator(int x1, int y1, int x2, int y2) {
		return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
	}
}