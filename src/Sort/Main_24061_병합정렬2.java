package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24061_병합정렬2 {
	static int input[], temp[];
	static int k, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		input = new int[n];
		temp = new int[n];
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(0, n-1);
		
		System.out.println(-1);
	}
	
	public static void sort(int left, int right) {
		if(left == right) return;
		
		int mid = (left+right)/2;
		
		sort(left, mid);
		sort(mid+1, right);
		
		merge(left, mid, right);
	}

	private static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int current = left;
		
		while(i <= mid && j <= right) {
			if(input[i] <= input[j]) {
				temp[current++] = input[i++];
			} else {
				temp[current++] = input[j++];
			}
		}
		
		while(i <= mid) {
			temp[current++] = input[i++];
		}
		while(j <= right) {
			temp[current++] = input[j++];
		}
		
		for(int idx = left; idx <= right; idx++) {
			input[idx] = temp[idx];
			if (++count == k) {
				print();
			}
		}
		
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
        for (int val : input) {
            if (val != 0) {
                sb.append(val).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        System.exit(0);
	}

}
