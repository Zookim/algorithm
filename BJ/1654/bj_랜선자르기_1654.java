package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_랜선자르기_1654 {
	//이분 탐색
	
	static int N,K;
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		int min=0;
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(min < arr[i]) {//부등호가 반대, 제일 작은 것은 선택하지 않을 수 도 있다.!!!!!
				min = arr[i];
			}
		}
		
		//입력
		long len = binarySearch(1, min);
		System.out.println(len);
		
	}

	static long binarySearch(long start,long end) {//1.재귀 ,2.반복문
		long mid = (start+end) /2;
		
		while(start <= end) {//start == end일때도 탐색해야한다.
			long num=0;
			for(int i=0;i<K;i++) {
				num += arr[i] /mid;
			}
			if(num < N) {//길이를 줄인다
				end = mid-1; //mid는 값이 아니다
			}else if(num >=N) { //길이를 늘린다.
				start = mid+1; //mid가 값일 수도 있다.
			}//만약 mid가 최선이었을 때,최종상태는 end가 mid로 가 있는 상태에서 멈춘다
			//따라서 start를 하려면 -1해주고, end를 쓰려면 바로사용
			
			mid = (start+end) /2;
		}
		//System.out.println(start+ " "+ end);
		
		return start-1;
		
		
		
	}
}
