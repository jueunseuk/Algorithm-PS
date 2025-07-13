package SlidingWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		//첫째줄에 임의 문자열 길이 S와 비밀번호의 문자열 길이 P를 입력
		StringTokenizer SP = new StringTokenizer(input, " ");
		int S = Integer.parseInt(SP.nextToken());
		int P = Integer.parseInt(SP.nextToken());
		
		//임의의 문자열 생성
		String DNAString = br.readLine();
		
		//세번째줄에 각각 포함되어야 할 ACTG의 개수를 공백을 구분자로 입력
		//총합은 S보다 작아야함
		input = br.readLine();
		StringTokenizer ACTG = new StringTokenizer(input, " ");
		int numA = Integer.parseInt(ACTG.nextToken());
		int numC = Integer.parseInt(ACTG.nextToken());
		int numT = Integer.parseInt(ACTG.nextToken());
		int numG = Integer.parseInt(ACTG.nextToken());
		
		//임의의 문자열을 배열로 변환
		String DNAChar[] = DNAString.split("");
		
		
//		ACTG가 각각 몇번씩 쓰였는지 체크
		int cntA = 0;
		int cntC = 0;
		int cntT = 0;
		int cntG = 0;
//		
//		for(int i = 0; i < DNAChar.length; i++) {
//			if(DNAChar[i].equals("A")) cntA++;
//			else if(DNAChar[i].equals("C")) cntC++;
//			else if(DNAChar[i].equals("T")) cntT++;
//			else if(DNAChar[i].equals("G")) cntG++;
//		}
//		//ACTG의 총 합은 S보다 작음을 보장
//		if(S < cntA+cntC+cntT+cntG) {
//			System.out.println("에러1");
//		}
		
		//총 개수가 S이고, 윈도우 사이즈가 P일 때 나올 수 있는 배열의 수는 S-P+1이고 이름은 DNAPtring
		String[] Ptring = new String[S-P+1];
		
		for(int i = 0; i < Ptring.length; i++) {
			//Ptring 에 값을 할당하기 위한 스트링 빌더
			StringBuilder tempString = new StringBuilder();
			
			for(int j = i; j < i+P ; j++) {
				tempString.append(DNAChar[j]);
			}
			
			//배열의 요소들을 만들어준 뒤 값 할당
			Ptring[i] = tempString.toString();
		}
		
//		//Ptring 의 각 요소들이 ACG를 최소 하나씩 포함하고 있는지 확인
		int passwordCnt = 0;
//		for(int i = 0; i < Ptring.length; i++) {
//			if(Ptring[i].indexOf("A") == -1 || Ptring[i].indexOf("C") == -1 || Ptring[i].indexOf("G") == -1) {
//			}
//		}
		
		//ACTG가 입력한 숫자만큼 포함되어 있는지 판단
		
		for(int i = 0; i < Ptring.length; i++) {
			cntA = 0;
			cntC = 0;
			cntT = 0;
			cntG = 0;
				//Ptring 을 배열로 변환하기 위한 임시 배열
				String[] tempArray = Ptring[i].split("");
				
				for (int j = 0; j < P; j++) {
	                char tempChar = Ptring[i].charAt(j); // 문자열을 char로 접근
	                if (tempChar == 'A') cntA++;         // equals 대신 == 사용
	                else if (tempChar == 'C') cntC++;
	                else if (tempChar == 'T') cntT++;
	                else if (tempChar == 'G') cntG++;
	            }//inner_for
			if(cntA >= numA && cntC >= numC && cntG >= numG && cntT >= numT) passwordCnt++;
		}//out_for
		
		
		System.out.println(passwordCnt);
		
		//민호가 만들 수 있는 비밀번호의 종류의 수 출력
//		System.out.println(passwordCnt);
	}

}