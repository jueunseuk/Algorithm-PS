package Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1068_트리 {
    static List<Integer>[] children;
    static int N, root;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        children = new ArrayList[N];
        for(int i=0; i<N; i++){
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] parent = new int[N];
        root = -1;
        for(int i=0; i<N; i++){
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) {
                root = i;
            } else {
                children[parent[i]].add(i);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());
        
        if(removeNode == root) {
            System.out.println(0);
            return;
        }

        System.out.println(countLeaves(removeNode));
    }

    public static int countLeaves(int removeNode) {
        boolean[] visited = new boolean[N];
        visited[root] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        int leafCount = 0;
        
        while(!stack.isEmpty()) {
            int curr = stack.pop();

            List<Integer> validChildren = new ArrayList<>();
            for(int nxt : children[curr]) {
                if(nxt == removeNode) continue;
                validChildren.add(nxt);
            }

            if(validChildren.size() == 0) {
                leafCount++;
            } else {
                for(int child : validChildren) {
                    if(!visited[child]) {
                        visited[child] = true;
                        stack.push(child);
                    }
                }
            }
        }
        
        return leafCount;
    }
}