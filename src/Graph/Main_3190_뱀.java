package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int size, apple, orders, currentD = 0, time = 0;
    static int[][] matrix;
    static boolean[][] exist;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        apple = Integer.parseInt(br.readLine());
        
        Queue<int[]> order = new LinkedList<>();
        Deque<int[]> snake = new ArrayDeque<>();
        
        matrix = new int[size][size];
        exist = new boolean[size][size];
        
        StringTokenizer st;
        for(int i = 0; i < apple; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	matrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        
        // snake initialization
        snake.offer(new int[] {0, 0});
        exist[0][0] = true;
        
        orders = Integer.parseInt(br.readLine());
        
        String timing, type;
        for(int i = 0; i < orders; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	timing = st.nextToken();
        	type = st.nextToken();
        	
        	if(type.equals("D")) {
        		order.offer(new int[] {Integer.parseInt(timing), 1});
        	} else {
        		order.offer(new int[] {Integer.parseInt(timing), -1});
        	}
        }
        
        // simulations
        while(!order.isEmpty()) {
        	int[] poll = order.poll();
        	
        	while(time < poll[0]) {
        		int[] head = snake.peekFirst();
        		
        		int nx = head[0] + dx[currentD];
        		int ny = head[1] + dy[currentD];
        		
        		if(nx < 0 || ny < 0 || nx >= size || ny >= size || exist[nx][ny]) {
        			System.out.println(time+1);
        			return;
        		}
        		
        		snake.offerFirst(new int[] {nx, ny});
        		exist[nx][ny] = true;
        		
        		if(matrix[nx][ny] == 0) {
        			exist[snake.peekLast()[0]][snake.peekLast()[1]]	= false;
        			snake.pollLast();
        		} else {
        			matrix[nx][ny] = 0;
        		}
        		time++;
        	}
        	
        	// direction setting
        	currentD += poll[1];
        	if(currentD < 0) {
        		currentD = 3;
        	} else if(currentD > 3) {
        		currentD = 0;
        	}
        }
        
        // not exit when order is empty
        while(true) {
        	int[] head = snake.peekFirst();
    		
    		int nx = head[0] + dx[currentD];
    		int ny = head[1] + dy[currentD];
    		
    		if(nx < 0 || ny < 0 || nx >= size || ny >= size || exist[nx][ny]) {
    			System.out.println(time+1);
    			return;
    		}
    		
    		snake.offerFirst(new int[] {nx, ny});
    		exist[nx][ny] = true;
    		
    		if(matrix[nx][ny] == 0) {
    			exist[snake.peekLast()[0]][snake.peekLast()[1]]	= false;
    			snake.pollLast();
    		}
    		time++;
        }
	}
}