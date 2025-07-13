package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20005_보스몬스터전리품 {
	static int row, col;
    static char[][] matrix;
    static Boss boss = new Boss();
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        int player = Integer.parseInt(st.nextToken());
        User[] users = new User[player];
        
        matrix = new char[row][col];
        
        // matrix setting & user, boss setting
        int userIdx = 0;
        for(int i = 0; i < row; i++) {
        	matrix[i] = br.readLine().toCharArray();
        	
        	for(int j = 0; j < col; j++) {
        		if('a' <= matrix[i][j] && matrix[i][j] <= 'z') {
        			users[userIdx++] = new User(matrix[i][j], i, j);
        			matrix[i][j] = '.';
        		} else if(matrix[i][j] == 'B') {
        			boss.setPosition(i, j);
        			matrix[i][j] = '.';
        		}
        	}
        }
        
        // user setting
        for(int i = 0; i < player; i++) {
        	st = new StringTokenizer(br.readLine());
        	User findUser = User.findUser(users, st.nextToken().charAt(0));
        	findUser.setDamage(Integer.parseInt(st.nextToken()));
        }
        
        boss.setHP(Integer.parseInt(br.readLine()));
        
        br.close();
        
        // user distance setting
        for(User user : users) {
        	user.setDistance(bfs(user.x, user.y));
        }
        
        Arrays.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.distance - o2.distance;
			}
        });
        
        // attack boss
        int idx = 0, time = 0, totalDamage = 0;
        while(boss.hp > 0) {
        	while(idx < player && users[idx].distance <= time) {
        		totalDamage += users[idx++].damage;
        	}
        	
        	boss.attack(totalDamage);
        	time++;
        }
        
        System.out.println(idx);
	}
    
    public static int bfs(int i, int j) {
    	Queue<int[]> q = new LinkedList<>();
    	boolean[][] visit = new boolean[row][col];
    	int length = 0;
    	
    	q.offer(new int[] {i, j, 0});
    	visit[i][j] = true;
    	
    	while(!q.isEmpty()) {
    		int[] poll = q.poll();
    		
    		if(poll[0] == boss.x && poll[1] == boss.y) {
    			return poll[2];
    		}
    		
    		for(int delta = 0; delta < 4; delta++) {
    			int nx = poll[0] + dx[delta];
    			int ny = poll[1] + dy[delta];
    			
    			if(nx >= 0 && ny >= 0 && nx < row && ny < col && !visit[nx][ny] && matrix[nx][ny] == '.') {
    				visit[nx][ny] = true;
    				q.offer(new int[] {nx, ny, poll[2]+1});
    			}
    		}
    	}
    	
    	return MAX;
    }
    
    public static class Boss {
    	int x;
    	int y;
    	int hp;
    	
    	public Boss() {
    	}
    	
    	public void attack(int totalDamage) {
    		this.hp -= totalDamage;
    	}
    	
    	public void setPosition(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}		
		
		public void setHP(int hp) {
			this.hp = hp;
		}
    }
    
    public static class User {
    	char id;
    	int x;
    	int y;
    	int damage;
    	int distance;
    	
    	public User(char id, int x, int y) {
    		this.id = id;
    		this.x = x;
    		this.y = y;
    	}
    	
    	public void setDamage(int damage) {
    		this.damage = damage;
    	}
    	
    	public void setDistance(int distance) {
    		this.distance = distance;
    	}
    	
    	public static User findUser(User[] users, char id) {
            for (User user : users) {
                if (user.id == id) {
                    return user;
                }
            }
            return null;
        }
    	
    }
}