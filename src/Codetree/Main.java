package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>(); 
	static int[] degree;
	static int[] time;
	static int[] dp;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("=================입력 전 주의사항=================");
        System.out.println("1. 작업물의 아이디는 숫자로 부여해서 입력해주세요.");
        System.out.println("2. 아이디의 번호는 1부터 순서대로 증가시켜서 부여해주세요.");
        System.out.println("3. 작업물의 선후 관계는 공백으로 구분해주세요.");
        System.out.println("4. A B는 \"B를 수행하기 위해선 A가 선행되어야 함\"을 의미\n");
        
        System.out.print("작업물의 개수를 알려주세요: ");
        try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Integer 타입으로 입력해주세요.");
			return;
		} catch (IOException e) {
			return;
		}
        
        degree = new int[n+1];
        time = new int[n+1];
        dp = new int[n+1];
        for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        System.out.println("각 작업물의 소요 시간을 알려주세요.");
        System.out.println("소요 시간을 공백으로 구분해서 한 줄에 입력\n");
        try {
			st = new StringTokenizer(br.readLine(), " ");
		} catch (IOException e) {
			System.out.println("입력이 올바르지 않습니다.");
			return;
		}
        
        for(int i = 1; i <= n; i++) {
        		try {
        			time[i] = Integer.parseInt(st.nextToken());
        		} catch(NoSuchElementException e) {
        			System.out.println("소요 시간이 "+n+"보다 적게 입력됐습니다.");
        			return;
        		}
        }
        
        System.out.print("선후 관계의 개수를 알려주세요: ");
        try {
			m = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Integer 타입으로 입력해주세요.");
			return;
		} catch (IOException e) {
			return;
		}
        
        System.out.println("선후 관계의 개수만큼 관계를 입력해주세요.");
        for(int i = 0; i < m; i++) {
        		try {
				st = new StringTokenizer(br.readLine(), " ");
			} catch (IOException e) {
				System.out.println("입력이 올바르지 않습니다.");
				return;
			}
        		
        		int start, end;
        		try {
        			start = Integer.parseInt(st.nextToken());
        			end = Integer.parseInt(st.nextToken());
        		} catch(NoSuchElementException e) {
        			System.out.println("선후 관계가 제대로 입력되지 않았습니다.");
        			return;
        		}
        		
        		list.get(start).add(end);
        		degree[end]++;
        }
        
        int type;
        System.out.print("보고 싶은 타입: ");
        System.out.println("ES -> 1");
        System.out.println("ES -> 2");
        System.out.println("ES -> 3");
        System.out.println("ES -> 4");
        System.out.println("ST -> 5");
        System.out.println("임계경로 -> 6");
        try {
        		type = Integer.parseInt(br.readLine());
        		
        		if(type > 6 || type < 1) {
        			System.out.println("타입은 1부터 6까지만 선택할 수 있습니다.");
        			return;
        		}
		} catch (NumberFormatException e) {
			System.out.println("Integer 타입으로 입력해주세요.");
			return;
		} catch (IOException e) {
			return;
		}
        
        switch(type) {
        		case 1: {
        			earlyStart();
        			break;
        		}
        		case 2: {
        			earlyFinish();
        			break;
        		}
        		case 3: {
        			latestStart();
        			break;
        		}
        		case 4: {
        			latestFinish();
        			break;
        		}
        		case 5: {
        			getSlackTime();
        			break;
        		}
        		case 6: {
        			getCriticalPath();
        			break;
        		}
        }
        
        for(int i = 1; i <= n; i++) {
        		if(degree[i] != 0) {
        			System.out.println("작업물 간 사이클이 존재하므로 작업을 진행할 수 없습니다.");
        			System.out.println("작업을 종료합니다.");
        			return;
        		}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void earlyStart() {
		Queue<Integer> q = new ArrayDeque<>();

		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {
				q.offer(i);
			}
		}
		
		sb.append("ES는 아래와 같습니다.\n");
		while (!q.isEmpty()) {
            int poll = q.poll();
            
            sb.append("작업 아이디:"+poll+" -> "+dp[poll]).append("\n");
            
            for (int out : list.get(poll)) {
                dp[out] = Math.max(dp[poll]+time[poll], dp[out]);
                if (--degree[out] == 0) q.offer(out);
            }
        }
	}

	private static void earlyFinish() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {
				q.offer(i);
				dp[i] = time[i];
			}
		}
		
		sb.append("EF는 아래와 같습니다.\n");
		while (!q.isEmpty()) {
            int poll = q.poll();
            
            sb.append("작업 아이디:"+poll+" -> "+dp[poll]).append("\n");
            
            for (int out : list.get(poll)) {
                dp[out] = Math.max(dp[out], dp[poll] + time[out]);
                if (--degree[out] == 0) q.offer(out);
            }
        }
	}
	
	private static void latestStart() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {
				q.offer(i);
				dp[i] = time[i];
			}
		}
		
		sb.append("LS는 아래와 같습니다.\n");
		while (!q.isEmpty()) {
            int poll = q.poll();
            
            sb.append("작업 아이디:"+poll+" -> "+dp[poll]).append("\n");
            
            for (int out : list.get(poll)) {
                dp[out] = Math.max(dp[out], dp[poll] + time[out]);
                if (--degree[out] == 0) q.offer(out);
            }
        }
	}
	
	private static void latestFinish() {
		
	}
	
	private static void getSlackTime() {
		latestStart();
		int[] ls = new int[n+1];
		for(int i = 1; i <= n; i++) {
			ls[i] = dp[i];
		}
		dp = new int[n+1];
		
		earlyStart();
		int[] es = new int[n+1];
		for(int i = 1; i <= n; i++) {
			es[i] = dp[i];
		}
		
		sb.setLength(0);
		
		for(int i = 1; i <= n; i++) {
			sb.append(i+"번 작업의 ST: "+(ls[i]-es[i])).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	private static void getCriticalPath() {
		
	}
}