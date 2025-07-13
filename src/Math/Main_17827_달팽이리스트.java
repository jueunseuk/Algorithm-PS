package Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17827_달팽이리스트 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cycle = Integer.parseInt(st.nextToken());
        
        int leafCnt = cycle-1;
        int cycleCnt = n-cycle+1;
        
        st = new StringTokenizer(br.readLine()," ");
        int leaf[] = new int[leafCnt];
        int arr[] = new int[cycleCnt];
        
        for(int i = 0; i < leaf.length; i++) {
        	leaf[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < arr.length; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
        	int input = Integer.parseInt(br.readLine());
        	if(input < cycle-1) {
        		sb.append(leaf[input]+"\n");
        	} else {
        		sb.append(arr[(input-leafCnt)%cycleCnt]).append("\n");
        	}
        }
        
        System.out.println(sb.toString().trim());
	}

}
