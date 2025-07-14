package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static int row, col, sharkCnt, earn = 0;
	static Section[][] matrix;
	
	static final int[] dx = {0, -1, 1, 0, 0};
	static final int[] dy = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		sharkCnt = Integer.parseInt(st.nextToken());
		
		matrix = new Section[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = new Section(i, j);
			}
		}
		
		for(int i = 0; i < sharkCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			Shark shark = new Shark(d, v, z);
			matrix[x][y].setShark(shark);
		}
		
		for (int fisher = 0; fisher < col; fisher++) {
            fishing(fisher);

            Section[][] nextMatrix = new Section[row][col];
            for (int i = 0; i < row; i++) {
            	for (int j = 0; j < col; j++) {
            		nextMatrix[i][j] = new Section(i, j);
            	}
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!matrix[i][j].isShark()) continue;
                    Shark curr = matrix[i][j].shark;
                    matrix[i][j].remove();

                    int speed = curr.velocity;
                    if (curr.direction <= 2) speed %= (row - 1) * 2;
                    else speed %= (col - 1) * 2;

                    int x = i, y = j, d = curr.direction;
                    int rem = speed;
                    while (rem-- > 0) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                            d = (d == 1 ? 2 : d == 2 ? 1 : d == 3 ? 4 : 3);
                            nx = x + dx[d];
                            ny = y + dy[d];
                        }
                        x = nx; y = ny;
                    }
                    curr.updateDirection(d);

                    if (nextMatrix[x][y].isShark()) {
                        if (nextMatrix[x][y].shark.size < curr.size)
                            nextMatrix[x][y].eat(curr);
                    } else {
                        nextMatrix[x][y].setShark(curr);
                    }
                }
            }
            
            matrix = nextMatrix;
        }
		
		System.out.println(earn);
	}
	
	private static void fishing(int me) {
		for(int i = 0; i < row; i++) {
			if(matrix[i][me].isShark()) {
				earn += matrix[i][me].shark.size;
				matrix[i][me].remove();
				break;
			}
		}
	}

	public static class Section {
		int x, y;
		Shark shark;
		
		public Section(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setShark(Shark shark) {
			this.shark = shark;
		}
		
		public void remove() {
			this.shark = null;
		}
		
		public void eat(Shark shark) {
			this.shark = shark;
		}
		
		public boolean isShark() {
			return shark != null;
		}
	}

	public static class Shark {
		int direction, velocity, size;

		public Shark(int direction, int velocity, int size) {
			this.direction = direction;
			this.velocity = velocity;
			this.size = size;
		}
		
		public void updateDirection(int nd) {
			this.direction = nd;
		}
	}
}