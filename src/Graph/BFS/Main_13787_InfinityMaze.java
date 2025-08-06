package Graph.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_13787_InfinityMaze {
	static int row, col, l;
    static char[][] matrix;
    
    static Map<Character, int[]> delta = new HashMap<>(); {
    	delta.put('N', new int[] {-1, 0});
    	delta.put('S', new int[] {1, 0});
    	delta.put('W', new int[] {0, -1});
    	delta.put('E', new int[] {0, 1});
    }
    static Set<Character> set = new HashSet<>(); {
    	set.add('N');
    	set.add('S');
    	set.add('W');
    	set.add('E');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true) {
        	st = new StringTokenizer(br.readLine(), " ");
        	row = Integer.parseInt(st.nextToken());
        	col = Integer.parseInt(st.nextToken());
        	l = Integer.parseInt(st.nextToken());
        	
        	if(row == 0) {
        		break;
        	}
        	
        	matrix = new char[row][col];
        	
        	int cx = 0, cy = 0;
        	char cd = 'N';
        	for(int i = 0; i < row; i++) {
        		matrix[i] = br.readLine().toCharArray();
        		for(int j = 0; j < col; j++) {
        			if(set.contains(matrix[i][j])) {
        				cx = i;
        				cy = j;
        				cd = matrix[i][j];
        			}
        		}
        	}
        	
        	
        }
        
        System.out.println(sb.toString().trim());
	}

}
