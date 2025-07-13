package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1058_친구 {
	static int size;
	static int result[][];
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        size = Integer.parseInt(br.readLine());
        
        result = new int[size][size];
        for(int i = 0; i < size; i++) {
        	Arrays.fill(result[i], 1000);
        	result[i][i] = 0;
        }
        
        char[] input;
        
        for(int i = 0; i < size; i++) {
        	input = br.readLine().toCharArray();
        	
        	for(int j = 0; j < size; j++) {
        		if(input[j] == 'Y') {
        			list.add(new int[] {i, j});
        		}
        	}
        }
        
        br.close();
        
        for(int[] out : list) {
        	result[out[0]][out[1]] = 1;
        }
        
        for(int k = 0; k < size; k++) {
        	for(int i = 0; i < size; i++) {
        		for(int j = 0; j < size; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
        		}
        	}
        }
        
        int max = 0;
        for(int i = 0; i < size; i++) {
        	int cnt = 0;
        	for(int j = 0; j < size; j++) {
        		if(i == j) continue;
        		
        		if(result[i][j] == 1 || result[i][j] == 2) {
        			cnt++;
        		}
        	}
        	
        	max = Math.max(max, cnt);
        }
        
        System.out.println(max);
	}
}