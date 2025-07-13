package DataStructure;
import java.io.*;
import java.util.*;

public class Main_1270 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> list = new HashMap<>();
            int majorityCount = size / 2;
            boolean found = false;
            int majorityElement = -1;
            for (int j = 0; j < size; j++) {
                if (st.hasMoreTokens()) {
                    int number = Integer.parseInt(st.nextToken());
                    int count = list.getOrDefault(number, 0) + 1;
                    list.put(number, count);
                    if (count > majorityCount) {
                        majorityElement = number;
                        found = true;
                    }
                }
            }
            if (found) {
                System.out.println(majorityElement);
            } else {
                System.out.println("SYJKGW");
            }
        }
    }
}
