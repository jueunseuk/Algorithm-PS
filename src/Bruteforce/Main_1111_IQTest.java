package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1111_IQTest {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(n == 1) {
        	System.out.println("A");
        } else if(n == 2) {
        	if(arr[0] == arr[1]) {
        		System.out.println(arr[0]);
        	} else {
        		System.out.println("A");
        	}
        } else {
        	if(arr[0] == arr[1]) {
        		boolean flag = true;
        		for(int i = 2; i < n; i++) {
        			if(arr[0] != arr[i]) {
        				flag = false;
        				break;
        			}
        		}
        		System.out.println(flag ? arr[0] : "B");
        	} else {
        		int a, b;

                if((arr[2] - arr[1]) % (arr[1] - arr[0]) != 0) {
                    System.out.println("B");
                    return;
                }

                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - arr[0] * a;

                boolean flag = true;
                for(int i = 0; i < n - 1; i++) {
                    if(arr[i + 1] != arr[i] * a + b) {
                    	flag = false;
                        break;
                    }
                }

                if(!flag) {
                    System.out.println("B");
                } else {
                    System.out.println(arr[n - 1] * a + b);
                }
        	}
        }
	}
}