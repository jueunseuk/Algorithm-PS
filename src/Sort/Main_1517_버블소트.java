package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1517_버블소트 {
	static int[] arr, temp;
	static long cnt;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        sort(0, n-1);
        
        System.out.println(cnt);
	}

	private static void sort(int left, int right) {
		if(left == right) return;
		
		int mid = (left+right)/2;
		
		sort(left, mid);
		sort(mid+1, right);
		
		merge(left, mid, right);
	}

	private static void merge(int left, int mid, int right) {
		
		int i = left;
		int j = mid+1;
		int k = left;
		
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				cnt += mid-i+1;
			}
		}
		
		while(i <= mid) {
			temp[k++] = arr[i++]; 
		}
		while(j <= right) {
			temp[k++] = arr[j++]; 
		}
		
		for(int idx = left; idx <= right; idx++) {
			arr[idx] = temp[idx];
		}
	}

}
