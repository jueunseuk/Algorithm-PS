package Sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24060_병합정렬1 {
	static int input[], temp[];
	static int k, result = -1;

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
		
		System.out.println(result);
		
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
				temp[current] = input[i++];
			} else {
				temp[current] = input[j++];
			}
			if(--k == 0) {
				result = temp[current];
			}
			current++;
		}
		
		while(i <= mid) {
			temp[current] = input[i++];
			if(--k == 0) {
				result = temp[current];
			}
			current++;
		}
		while(j <= right) {
			temp[current] = input[j++];
			if(--k == 0) {
				result = temp[current];
			}
			current++;
		}
		
		for(int idx = left; idx <= right; idx++) {
			input[idx] = temp[idx];
		}
	}

}
/*
 * 병합 정렬의 핵심은 전부 다 쪼갠 다음에 합치면서 정렬하는 것
 * 양쪽 배열의 길이가 다를 수도 있기 때문에 남은 원소들까지 추가해야 함
 * temp 에 임시 저장해도 되고, 그냥 merge마다 임시 좌/우 배열 만들어서 바로 input 변경해도 됨
 * */