package TwoPointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14746_ClosestPair {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		// line 1
		st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// line 2
		st = new StringTokenizer(br.readLine(), " ");
		long gapY = Math.abs(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));

		// line 3
		st = new StringTokenizer(br.readLine(), " ");
		long arrP[] = new long[P];
		for(int i = 0; i < P; i++) {
			arrP[i] = Long.parseLong(st.nextToken());
		}
		
		// line 4
		st = new StringTokenizer(br.readLine(), " ");
		long arrQ[] = new long[Q];
		for(int i = 0; i < Q; i++) {
			arrQ[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arrP);
		Arrays.sort(arrQ);
		
		int idxP = 0, idxQ = 0;
		long cnt = 0, minDis = Long.MAX_VALUE;
		
		while(idxP < P && idxQ < Q) {
			long gapXY = Math.abs(arrP[idxP]-arrQ[idxQ]) + gapY;
			
			if (gapXY < minDis) {
                minDis = gapXY;
                cnt = 1;
            } else if (gapXY == minDis) {
                cnt++;
            }

            if (arrP[idxP] < arrQ[idxQ]) {
                idxP++;
            } else {
                idxQ++;
            }
		}
		
		System.out.println(minDis+" "+cnt);
		br.close();
	}

}
