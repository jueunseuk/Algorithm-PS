package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_16934_게임닉네임 {
	static class Node {
		Node[] child = new Node[26];
	}
	
	static Node root = new Node();
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String nick = br.readLine();
			map.put(nick, map.getOrDefault(nick, 0)+1);
			int prefixLen = findPrefix(nick);
			if(prefixLen != 0) {
				sb.append(nick.substring(0, prefixLen));
			} else {
				int cnt = map.get(nick);
				if(cnt == 1) {
					sb.append(nick);
				} else {
					sb.append(nick+cnt);
				}
			}
			sb.append("\n");
			addNickname(nick);
		}
		
		System.out.println(sb.toString().trim());
	}

	private static void addNickname(String nick) {
		Node cur = root;
		for(int i = 0; i < nick.length(); i++) {
			int c = nick.charAt(i) - 'a';
			if(cur.child[c] == null) cur.child[c] = new Node();
			cur = cur.child[c];
		}
	}

	private static int findPrefix(String nick) {
		Node cur = root;
		for(int i = 0; i < nick.length(); i++) {
			int c = nick.charAt(i) - 'a';
			if(cur.child[c] == null) {
				return i+1;
			}
			cur = cur.child[c];
		}
		return 0;
	}

}
