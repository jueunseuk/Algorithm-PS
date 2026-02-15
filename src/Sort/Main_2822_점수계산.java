package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2822_점수계산 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Score[] scores = new Score[8];
        for(int i = 0; i < 8; i++) {
        	scores[i] = new Score(i+1, Integer.parseInt(br.readLine()));
        }
        
        Arrays.sort(scores);
        
        int sum = 0;
        int[] idxs = new int[5];
        for(int i = 0; i < 5; i++) {
        	sum += scores[7-i].score;
        	idxs[i] = scores[7-i].idx;
        }
        
        Arrays.sort(idxs);
        
        System.out.println(sum);
        System.out.println(idxs[0]+" "+idxs[1]+" "+idxs[2]+" "+idxs[3]+" "+idxs[4]);
	}

	public static class Score implements Comparable<Score> {
		int idx;
		int score;
		
		public Score(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(Score o) {
			if(this.score == o.score) {
				return this.idx - o.idx;
			}
			return this.score - o.score;
		}
	}
}