package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_31945_정육면체의네꼭짓점 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        Set<Integer> up = new HashSet<>();
        up.add(1);
        up.add(3);
        up.add(5);
        up.add(7);
        Set<Integer> down = new HashSet<>();
        down.add(0);
        down.add(2);
        down.add(4);
        down.add(6);
        Set<Integer> front = new HashSet<>();
        front.add(4);
        front.add(5);
        front.add(6);
        front.add(7);
        Set<Integer> back = new HashSet<>();
        back.add(0);
        back.add(1);
        back.add(2);
        back.add(3);
        Set<Integer> left = new HashSet<>();
        left.add(0);
        left.add(1);
        left.add(4);
        left.add(5);
        Set<Integer> right = new HashSet<>();
        right.add(2);
        right.add(3);
        right.add(6);
        right.add(7);
        
        StringTokenizer st;
        Set<Integer> comp = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	for(int i = 0; i < 4; i++) {
        		comp.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	if(comp.containsAll(up) || comp.containsAll(down) || comp.containsAll(front) || comp.containsAll(back) || comp.containsAll(left) || comp.containsAll(right)) {
        		sb.append("YES");
        	} else {
        		sb.append("NO");
        	}
        	
        	sb.append("\n");
        	comp.clear();
        }

        System.out.println(sb.toString().trim());
	}

}
