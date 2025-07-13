package Bruteforce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_14888 { 
	
	static int N;
	static int[] num, operInput;
	static List<String> oper = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//숫자열 개수 입력
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		operInput = new int[4]; // 부호 개수 저장할 배열
		String[] str = br.readLine().split(" ");
		//숫자열 입력
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(str[i]);
		//부호 개수 입력
		str = br.readLine().split(" ");
		for(int i = 0; i < N-1; i++) operInput[i] = Integer.parseInt(str[i]);
		//부호를 배열로 변환
		for(int i = 0; i < operInput[0]; i++) oper.add("+");
		for(int i = operInput[0]; i < operInput[1]; i++) oper.add("-");
		for(int i = operInput[1]; i < operInput[2]; i++) oper.add("*");
		for(int i = operInput[2]; i < operInput[3]; i++) oper.add("/");
		
		System.out.println(oper.toString());
		
	}//main
	
	public static void perm(int depth) {
		if(depth == N) { //재귀 종료할 조건
            for(int i = 0; i < N; i++) {
                sb.append(operInput[i]).append(' ');
            }
            sb.setLength(sb.length() - 1); // 마지막 공백 제거
            sb.append('\n');
			return;
		}//if
		
		// 반복적인 재귀 호출
		for(int i = 1; i <= N; i++) {
			//선택되지 않았다면 실행
			operInput[depth] = i;
			perm(depth+1);
		}//for
	}//perm
}//class