package StringAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_20210_파일탐색기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<List<String>> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            List<String> temp = new ArrayList<>();
            StringBuilder sTemp = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (Character.isDigit(c)) {
                    sTemp.append(c);
                } else {
                    if (sTemp.length() > 0) {
                        temp.add(sTemp.toString());
                        sTemp.setLength(0);
                    }
                    temp.add(String.valueOf(c));
                }
            }

            if (sTemp.length() > 0) {
                temp.add(sTemp.toString());
            }

            v.add(temp);
        }

        Collections.sort(v, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                int minSize = Math.min(a.size(), b.size());

                for (int i = 0; i < minSize; i++) {
                    String partA = a.get(i);
                    String partB = b.get(i);

                    if (!partA.equals(partB)) {
                        boolean isNumA = Character.isDigit(partA.charAt(0));
                        boolean isNumB = Character.isDigit(partB.charAt(0));

                        if (isNumA && isNumB) {
                            String aNum = trimLeadingZeros(partA);
                            String bNum = trimLeadingZeros(partB);

                            if (aNum.equals(bNum)) {
                                return Integer.compare(partA.length(), partB.length());
                            }

                            if (aNum.length() != bNum.length()) {
                                return Integer.compare(aNum.length(), bNum.length());
                            }

                            return aNum.compareTo(bNum);
                        }

                        if (isNumA || isNumB) {
                            return isNumA ? -1 : 1;
                        }

                        if (Character.toUpperCase(partA.charAt(0)) == Character.toUpperCase(partB.charAt(0))) {
                            return partA.compareTo(partB);
                        }

                        return Character.toUpperCase(partA.charAt(0)) - Character.toUpperCase(partB.charAt(0));
                    }
                }

                return Integer.compare(a.size(), b.size());
            }
        });

        for (List<String> strings : v) {
            for (String part : strings) {
                sb.append(part);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static String trimLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
