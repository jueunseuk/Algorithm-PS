package Geometry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13411_미사일 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Robot[] robot = new Robot[n];
        
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int velocity = Integer.parseInt(st.nextToken());
        	
        	robot[i-1] = new Robot(i, x, y, velocity);
        	robot[i-1].makeDiv(x, y, velocity);
        }
        
        Arrays.sort(robot, new Comparator<Robot>() {
			@Override
			public int compare(Robot o1, Robot o2) {
				if(o1.div == o2.div) {
					return o1.id - o2.id;
				}
				return Double.compare(o1.div, o2.div);
			}
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(Robot out : robot) {
        	sb.append(out.id).append("\n");
        }
        
        System.out.println(sb.toString().trim());

	}
	
	public static class Robot {
		int id;
		int x;
		int y;
		int velocity;
		double div;
		
		public Robot(int id, int x, int y, int velocity) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.velocity = velocity;
		}
		
		public void makeDiv(int x, int y, int velocity) {
			int sum = x*x + y*y;
			int vv = velocity*velocity;
			this.div = sum / vv;
		}
	}

}
