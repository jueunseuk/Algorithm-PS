package Preprocessing;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12791_starman {
	static int year[] = {
			1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975,
            1976, 1977, 1977, 1979, 1980, 1983, 1984, 1987, 1993,
            1995, 1997, 1999, 2002, 2003, 2013, 2016
		};
	static String[] title = {
            "DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory",
            "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", "AladdinSane",
            "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation",
            "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance",
            "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside",
            "Earthling", "Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"
        };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Q = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int q = 0; q < Q; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	execute(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        System.out.println(sb.toString().trim());

	}

	private static void execute(int start, int end) {
		int startIdx = startCalc(start);
		int endIdx = endCalc(end);
		
		sb.append(endIdx-startIdx+1).append("\n");
		
		for(int i = startIdx; i <= endIdx; i++) {
			sb.append(year[i]+" "+title[i]).append("\n");
		}
	}

	private static int endCalc(int end) {
		for(int i = 24; i >= 0; i--) {
			if(year[i] <= end) {
				return i;
			}
		}
		return -1;
	}

	private static int startCalc(int start) {
		for(int i = 0; i < 25; i++) {
			if(year[i] >= start) {
				return i;
			}
		}
		return -1;
	}

}
