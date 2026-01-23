package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_35157_점세개돌리기 {
	static int n, Q;
	static int v1[] = {1, 0, 0};
	static int v2[] = {0, 1, 0};
	static int v3[] = {0, 0, 1};
	static int[][][] sum;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        sum = new int[3][n+1][3];
        sum[0][0] = v1;
        sum[1][0] = v2;
        sum[2][0] = v3;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
        	switch(st.nextToken()) {
        		case "X": {
        			rotateX(0, i); rotateX(1, i); rotateX(2, i);
        			break;
        		}
        		case "Y": {
        			rotateY(0, i); rotateY(1, i); rotateY(2, i);
        			break;
        		}
        		case "Z": {
        			rotateZ(0, i); rotateZ(1, i); rotateZ(2, i);
        			break;
        		}
        		case "XX": {
        			flipX(0, i); flipX(1, i); flipX(2, i);
        			break;
        		}
        		case "YY": {
        			flipY(0, i); flipY(1, i); flipY(2, i);
        			break;
        		}
        		case "ZZ": {
        			flipZ(0, i); flipZ(1, i); flipZ(2, i);
        			break;
        		}
        		case "XY": {
        			flipXY(0, i); flipXY(1, i); flipXY(2, i);
        			break;
        		}
        		case "YX": {
        			flipXY(0, i); flipXY(1, i); flipXY(2, i);
        			break;
        		}
        		case "YZ": {
        			flipYZ(0, i); flipYZ(1, i); flipYZ(2, i);
        			break;
        		}
        		case "ZY": {
        			flipYZ(0, i); flipYZ(1, i); flipYZ(2, i);
        			break;
        		}
        		case "XZ": {
        			flipXZ(0, i); flipXZ(1, i); flipXZ(2, i);
        			break;
        		}
        		case "ZX": {
        			flipXZ(0, i); flipXZ(1, i); flipXZ(2, i);
        			break;
        		}
        	}
        }
        
        Q = Integer.parseInt(br.readLine());
        
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int a00 = sum[0][l-1][0], a10 = sum[0][l-1][1], a20 = sum[0][l-1][2];
            int a01 = sum[1][l-1][0], a11 = sum[1][l-1][1], a21 = sum[1][l-1][2];
            int a02 = sum[2][l-1][0], a12 = sum[2][l-1][1], a22 = sum[2][l-1][2];

            int b00 = sum[0][r][0], b10 = sum[0][r][1], b20 = sum[0][r][2];
            int b01 = sum[1][r][0], b11 = sum[1][r][1], b21 = sum[1][r][2];
            int b02 = sum[2][r][0], b12 = sum[2][r][1], b22 = sum[2][r][2];

            int m00 = b00*a00 + b01*a01 + b02*a02;
            int m01 = b00*a10 + b01*a11 + b02*a12;
            int m02 = b00*a20 + b01*a21 + b02*a22;

            int m10 = b10*a00 + b11*a01 + b12*a02;
            int m11 = b10*a10 + b11*a11 + b12*a12;
            int m12 = b10*a20 + b11*a21 + b12*a22;

            int m20 = b20*a00 + b21*a01 + b22*a02;
            int m21 = b20*a10 + b21*a11 + b22*a12;
            int m22 = b20*a20 + b21*a21 + b22*a22;

            sb.append(m00).append(' ').append(m10).append(' ').append(m20).append('\n');
            sb.append(m01).append(' ').append(m11).append(' ').append(m21).append('\n');
            sb.append(m02).append(' ').append(m12).append(' ').append(m22).append('\n');
        }

        
        System.out.println(sb.toString().trim());
	}
	
	public static void rotateX(int v, int i) {
		sum[v][i][0] = sum[v][i-1][0];
		sum[v][i][1] = -sum[v][i-1][2];
		sum[v][i][2] = sum[v][i-1][1];
	}
	
	public static void rotateY(int v, int i) {
		sum[v][i][0] = sum[v][i-1][2];
		sum[v][i][1] = sum[v][i-1][1];
		sum[v][i][2] = -sum[v][i-1][0];
	}
	
	public static void rotateZ(int v, int i) {
		sum[v][i][0] = -sum[v][i-1][1];
		sum[v][i][1] = sum[v][i-1][0];
		sum[v][i][2] = sum[v][i-1][2];
	}
	
	public static void flipX(int v, int i) {
		sum[v][i][0] = sum[v][i-1][0];
		sum[v][i][1] = -sum[v][i-1][1];
		sum[v][i][2] = -sum[v][i-1][2];
	}
	
	public static void flipY(int v, int i) {
		sum[v][i][0] = -sum[v][i-1][0];
		sum[v][i][1] = sum[v][i-1][1];
		sum[v][i][2] = -sum[v][i-1][2];
	}
	
	public static void flipZ(int v, int i) {
		sum[v][i][0] = -sum[v][i-1][0];
		sum[v][i][1] = -sum[v][i-1][1];
		sum[v][i][2] = sum[v][i-1][2];
	}

	public static void flipXY(int v, int i) {
		sum[v][i][0] = sum[v][i-1][0];
		sum[v][i][1] = sum[v][i-1][1];
		sum[v][i][2] = -sum[v][i-1][2];
	}
	
	public static void flipYZ(int v, int i) {
		sum[v][i][0] = -sum[v][i-1][0];
		sum[v][i][1] = sum[v][i-1][1];
		sum[v][i][2] = sum[v][i-1][2];
	}
	
	public static void flipXZ(int v, int i) {
		sum[v][i][0] = sum[v][i-1][0];
		sum[v][i][1] = -sum[v][i-1][1];
		sum[v][i][2] = sum[v][i-1][2];
	}
}