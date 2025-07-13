package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_4358 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Double> map = new HashMap<>();
        
        double total = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            
            map.put(input, map.getOrDefault(input, 0.0) + 1);
            total++;
        }
        
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<String, Double> entry : list) {
            double rate = (entry.getValue() / total) * 100;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", rate)).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
