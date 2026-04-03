package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<List<Integer>> list = new ArrayList<>(); 
	static List<List<Integer>> reverse = new ArrayList<>(); 
	static int[] time;
	static int[] degree;
	static int[] reverseDegree;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("==================================================");
        System.out.println("                     입력 안내                     ");
        System.out.println("==================================================");

        System.out.println("[1] 작업물 개수 입력");
        System.out.println(" - 첫 줄에 작업물의 개수를 입력하세요.\n");

        System.out.println("[2] 작업 시간 입력");
        System.out.println(" - 두 번째 줄에 각 작업의 소요 시간을 입력하세요.");
        System.out.println(" - 공백으로 구분 (예: 2 6 4 2 4 ...)");
        System.out.println(" - 작업 ID는 1부터 순차적으로 부여됩니다.\n");

        System.out.println("[3] 관계 개수 입력");
        System.out.println(" - 세 번째 줄에 관계 개수를 입력하세요.\n");

        System.out.println("[4] 선후 관계 입력");
        System.out.println(" - 다음 " + m + "개의 줄에 관계를 입력하세요.");
        System.out.println(" - 형식: A B (B 수행 전 A 선행 필요)\n");

        System.out.println("[5] 결과 타입 선택");
        System.out.println(" - 1 : ES (Earliest Start)");
        System.out.println(" - 2 : EF (Earliest Finish)");
        System.out.println(" - 3 : LS (Latest Start)");
        System.out.println(" - 4 : LF (Latest Finish)");
        System.out.println(" - 5 : ST (Slack Time)");
        System.out.println(" - 6 : CP (Critical Path: 개발 예정)\n");
        
        System.out.println("[6] 주의");
        System.out.println("입력이 형식에 맞지 않은 경우 즉시 종료됩니다.\n");

        System.out.println("==================================================\n");
        
        try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Integer 타입으로 입력해주세요.");
			return;
		} catch (IOException e) {
			return;
		}
        
        degree = new int[n+1];
        reverseDegree = new int[n+1];
        time = new int[n+1];
        for(int i = 0; i <= n; i++) {
        		list.add(new ArrayList<>());
        		reverse.add(new ArrayList<>());
        }
        
        StringTokenizer st;
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
        
        try {
			m = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Integer 타입으로 입력해주세요.");
			return;
		} catch (IOException e) {
			return;
		}
        
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
        		
        		reverse.get(end).add(start);
        		reverseDegree[start]++;
        }
        
        int type;
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
        			int[] dp = new int[n+1];
        			earlyStart(dp);
        			break;
        		}
        		case 2: {
        			int[] dp = new int[n+1];
        			earlyFinish(dp);
        			break;
        		}
        		case 3: {
        			int[] dp = new int[n+1];
        			latestStart(dp);
        			break;
        		}
        		case 4: {
        			int[] dp = new int[n+1];
        			latestFinish(dp);
        			break;
        		}
        		case 5: {
        			int[] dp = new int[n+1];
        			int[] dp2 = new int[n+1];
        			getSlackTime(dp, dp2);
        			break;
        		}
        		case 6: {
        			getCriticalPath();
        			System.out.println("구현 예정");
        			return;
        		}
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void earlyStart(int[] dp) {
		Queue<Integer> q = new ArrayDeque<>();

		int[] top = copyArray(degree);
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		sb.append("ES는 아래와 같습니다.\n");
		while (!q.isEmpty()) {
            int poll = q.poll();
            
            sb.append("작업 아이디:"+poll+" -> "+dp[poll]).append("\n");
            
            for (int out : list.get(poll)) {
                dp[out] = Math.max(dp[poll]+time[poll], dp[out]);
                if (--top[out] == 0) q.offer(out);
            }
        }
		
		isIncludeCycle(top);
	}

	private static void earlyFinish(int[] dp) {
		earlyStart(dp);
		
		sb.setLength(0);
		sb.append("EF는 아래와 같습니다.\n");
		for(int i = 1; i <= n; i++) {
			sb.append("작업 아이디:"+i+" -> "+(dp[i]+time[i])).append("\n");
		}
	}
	
	private static void latestStart(int[] dp) {
		int[] es = new int[n+1];
		earlyStart(es);
		int maxTime = 0;
	    for (int i = 1; i <= n; i++) {
	        maxTime = Math.max(maxTime, es[i] + time[i]);
	    }
		
		Queue<Integer> q = new ArrayDeque<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		int[] top = copyArray(reverseDegree);
		for(int i = 1; i <= n; i++) {
			if(top[i] == 0) {
				q.offer(i);
			}
		}
		
		sb.setLength(0);
		sb.append("LS는 아래와 같습니다.\n");
		while (!q.isEmpty()) {
            int poll = q.poll();
            
            sb.append("작업 아이디:"+poll+" -> "+dp[poll]).append("\n");
            
            for (int out : reverse.get(poll)) {
                dp[out] = Math.max(dp[out], dp[poll] + time[out]);
                if (--top[out] == 0) q.offer(out);
            }
        }
		
		isIncludeCycle(top);
	}
	
	private static void latestFinish(int[] dp) {
		
	}
	
	private static void getSlackTime(int[] dp, int[] dp2) {
		latestStart(dp);
		earlyStart(dp2);
		
		sb.setLength(0);
		sb.append("ST는 아래와 같습니다.\n");
		for(int i = 1; i <= n; i++) {
			sb.append(i+"번 작업의 ST: "+(dp[i]-dp2[i])).append("\n");
		}
	}
	
	private static void getCriticalPath() {
		
	}
	
	private static void isIncludeCycle(int[] degree) {
		for(int i = 1; i <= n; i++) {
	    		if(degree[i] != 0) {
	    			System.out.println("작업물 간 사이클이 존재하므로 작업을 진행할 수 없습니다.");
	    			System.out.println("작업을 종료합니다.");
	    			System.exit(0);
	    		}
	    }
	}
	
	private static int[] copyArray(int[] arr) {
		int[] copy = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}
}