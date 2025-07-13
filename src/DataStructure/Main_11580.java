package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11580 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int visited[][] = new int[2001][2001];
		visited[1000][1000] = 1;
		int current[] = {1000, 1000};
		
		String cmd = br.readLine();
		
		
		for(int i = 0; i < N; i++) {
			switch(cmd.charAt(i)) {
				case 'E' : {
	                current[0] += 1; break; // 동쪽으로 이동
	            }
	            case 'W' : {
	                current[0] -= 1; break; // 서쪽으로 이동
	            }
	            case 'N' : {
	                current[1] += 1; break; // 북쪽으로 이동
	            }
	            case 'S' : {
	                current[1] -= 1; break; // 남쪽으로 이동
	            }
			}//switch
			visited[current[0]][current[1]] = 1;
		}//for
		int sum = 0;
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[i].length; j++) {
				sum += visited[i][j];
			}
		}
		
		System.out.println(sum);
	}//main

}
