package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4167_TunnelingTheEarth {
    static final double R = 6371009.0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            double lat1 = Math.toRadians(Double.parseDouble(st.nextToken()));
            double lon1 = Math.toRadians(Double.parseDouble(st.nextToken()));
            double lat2 = Math.toRadians(Double.parseDouble(st.nextToken()));
            double lon2 = Math.toRadians(Double.parseDouble(st.nextToken()));

            double x1 = R * Math.cos(lat1) * Math.cos(lon1);
            double y1 = R * Math.cos(lat1) * Math.sin(lon1);
            double z1 = R * Math.sin(lat1);

            double x2 = R * Math.cos(lat2) * Math.cos(lon2);
            double y2 = R * Math.cos(lat2) * Math.sin(lon2);
            double z2 = R * Math.sin(lat2);

            double dot = x1 * x2 + y1 * y2 + z1 * z2;
            double cosTheta = dot / (R * R);

            if (cosTheta > 1.0) cosTheta = 1.0;
            if (cosTheta < -1.0) cosTheta = -1.0;

            double theta = Math.acos(cosTheta);

            double surface = R * theta;
            double tunnel = 2.0 * R * Math.sin(theta/2);

            long diff = Math.round(surface - tunnel);
            sb.append(diff).append('\n');
        }

        System.out.print(sb.toString());
    }
}