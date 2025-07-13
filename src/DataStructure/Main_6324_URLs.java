package DataStructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_6324_URLs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        String regex = "^(\\w+)://([\\w.\\-]+)(?::(\\d+))?(/.*)?$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= T; i++) {
            String urlString = br.readLine();
            System.out.println("URL #" + i);
            
            Matcher matcher = pattern.matcher(urlString);
            if (matcher.matches()) {
                String protocol = matcher.group(1);
                String host = matcher.group(2);
                String port = matcher.group(3) == null ? "<default>" : matcher.group(3);
                String path = matcher.group(4) == null ? "<default>" : matcher.group(4).substring(1);

                System.out.println("Protocol = " + protocol);
                System.out.println("Host     = " + host);
                System.out.println("Port     = " + port);
                System.out.println("Path     = " + path);
            }
            System.out.println();
        }
    }
}