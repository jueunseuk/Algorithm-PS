package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main_3111_검열 {
    static boolean goodToErase(List<Character> v, String s) {
        int diff = v.size() - s.length();
        for (int i = 0; i < s.length(); i++) {
            if (v.get(diff + i) != s.charAt(i)) return false;
        }
        return true;
    }

    static boolean ifThen(List<Character> v, String a) {
        if (v.size() >= a.length()) {
            if (goodToErase(v, a)) {
                for (int i = 0; i < a.length(); i++) {
                    v.remove(v.size() - 1);
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String T = br.readLine();
        
        Deque<Character> dq = new ArrayDeque<>();
        
        for (int i = 0; i < T.length(); i++) dq.addLast(T.charAt(i));
        
        StringBuilder sb = new StringBuilder(A).reverse();
        String reverseA = sb.toString();
        
        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        
        char leftTrigger = reverseA.charAt(0);
        char rightTrigger = A.charAt(0);
        
        int thSize = A.length();
        
        boolean dir = true;
        
        while (!dq.isEmpty()) {
            if (dir) {
                char c = dq.pollFirst();
                left.add(c);
                if (c == leftTrigger) {
                    if (left.size() >= thSize) {
                        if (ifThen(left, A)) dir = !dir;
                    }
                }
            } else {
                char c = dq.pollLast();
                right.add(c);
                if (c == rightTrigger) {
                    if (right.size() >= thSize) {
                        if (ifThen(right, reverseA)) dir = !dir;
                    }
                }
            }
        }
        
        while (!left.isEmpty() && !right.isEmpty()) {
            if (dir) {
                char c = right.remove(right.size() - 1);
                left.add(c);
                if (c == leftTrigger) {
                    if (left.size() >= thSize) {
                        if (ifThen(left, A)) dir = !dir;
                    }
                }
            } else {
                char c = left.remove(left.size() - 1);
                right.add(c);
                if (c == rightTrigger) {
                    if (right.size() >= thSize) {
                        if (ifThen(right, reverseA)) dir = !dir;
                    }
                }
            }
        }
        
        while (!left.isEmpty()) {
            right.add(left.remove(left.size() - 1));
        }
        
        StringBuilder ans = new StringBuilder();
        while (!right.isEmpty()) {
            ans.append(right.remove(right.size() - 1));
        }
        
        System.out.println(ans);
    }
}
