package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24062_병합정렬3 {
	static int input[], temp[], target[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		input = new int[n];
		temp = new int[n];
		target = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		if(isSameArray(target, input)) {
			System.out.println(1);
			return;
		}
		
		sort(0, n-1);
		
		System.out.println(0);
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
		}
		
		if (isSameInRange(left, right)) {
            System.out.println(1);
            System.exit(0);
        }
	}

	private static boolean isSameArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    private static boolean isSameInRange(int left, int right) {
        for (int i = left; i <= right; i++) {
            if (input[i] != target[i]) return false;
        }
        return true;
    }
}
