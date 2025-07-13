package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_33578_누가이름안적고나갔어 {
	static final int INF = 100000000;
	
	static int row, col, min = Integer.MAX_VALUE;
	static char[][] matrix;
	static int[][][] cost;
	
	static final int dx[] = {1, -1, 0, 0};
	static final int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		matrix = new char[row][col];
		
		for(int i = 0; i < row; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		dijkstra();
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}


	private static void dijkstra() {
		Queue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
	    cost = new int[row][col][2];
	    
	    for (int i=0;i<row;i++)
	        for (int j=0;j<col;j++)
	            cost[i][j][0] = cost[i][j][1] = INF;

	    for (int i=0;i<row;i++)
	        for (int j=0;j<col;j++)
	            if (matrix[i][j]=='J') {
	                cost[i][j][0]=0;
	                pq.offer(new Node(i,j,0,0));
	            }

	    while (!pq.isEmpty()) {
	        Node cur = pq.poll();
	        if (cur.cost!=cost[cur.x][cur.y][cur.type]) continue;
	        if (matrix[cur.x][cur.y]=='S') {
	            min = cur.cost;
	            return;
	        }

	        for (int d=0; d<4; d++) {
	            int nx=cur.x+dx[d], ny=cur.y+dy[d];
	            if (nx<0||ny<0||nx>=row||ny>=col) continue;
	            if (matrix[nx][ny]=='#') continue;

	            int nt = (matrix[nx][ny]=='T')?1:cur.type;
	            int nCost = cur.cost + (cur.type==0?2:1);

	            if (nCost < cost[nx][ny][nt]) {
	                cost[nx][ny][nt] = nCost;
	                pq.offer(new Node(nx,ny,nt,nCost));
	            }
	        }
	    }
	}

	static class Node {
	    int x,y,type,cost;
	    Node(int x,int y,int type,int cost){
	        this.x=x; this.y=y; this.type=type; this.cost=cost;
	    }
	}
}