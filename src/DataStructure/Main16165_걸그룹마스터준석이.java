package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, List<String>> groupMembers = new HashMap<>();
        Map<String, String> memberGroup = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int numMembers = Integer.parseInt(br.readLine());
            
            List<String> members = new ArrayList<>();
            
            for (int j = 0; j < numMembers; j++) {
                String memberName = br.readLine();
                members.add(memberName);
                memberGroup.put(memberName, groupName);
            }
            
            Collections.sort(members);
            groupMembers.put(groupName, members);
        }
        
        int type;
        String query;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	query = br.readLine();
            type = Integer.parseInt(br.readLine());
            
            if(type == 0) {
                List<String> members = groupMembers.get(query);
                for (String member : members) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(memberGroup.get(query)).append("\n");
            }
        }
        
        System.out.print(sb.toString().trim());
    }
}
