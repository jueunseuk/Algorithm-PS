package StringAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String object[] = new String[20];
		double gkrwja[] = new double[20];
		String grade[] = new String[20];
		double gradeToScore[] = new double[20];
		int sumgkrwja = 0;
		double sumGrade = 0.0;
		int []passPos = new int[20]; // 0인 과목은 계산하지 않음
		Arrays.fill(passPos, 1);
		
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			object[i] = st.nextToken();
			gkrwja[i] = Double.parseDouble(st.nextToken());
			grade[i] = st.nextToken();
		}
		
		for(int i = 0; i < 20; i++) {
			switch(grade[i]) {
			case "A+" : gradeToScore[i] = 4.5; break;
			case "A0" : gradeToScore[i] = 4.0; break;
			case "B+" : gradeToScore[i] = 3.5; break;
			case "B0" : gradeToScore[i] = 3.0; break;
			case "C+" : gradeToScore[i] = 2.5; break;
			case "C0" : gradeToScore[i] = 2.0; break;
			case "D+" : gradeToScore[i] = 1.5; break;
			case "D0" : gradeToScore[i] = 1.0; break;
			case "F" : gradeToScore[i] = 0.0; break;
			default : gradeToScore[i] = 0.0; passPos[i] = 0; break;
			}
		}
		
		for(int i = 0; i < 20; i++) {
			if(passPos[i] == 1) {
				sumGrade += gkrwja[i]*gradeToScore[i];
				sumgkrwja += gkrwja[i];
			}
		}
		
		System.out.println(sumGrade/sumgkrwja);
		
	}

}
