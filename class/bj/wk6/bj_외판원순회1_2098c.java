package bj.wk6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_외판원순회1_2098c {

	static int N,allMask,INF = 987654321;
	static int W[][];
	static int dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//5개의 도시 => 11111 => 1<<5 = 100000 여기서 -1해주면 11111이된다.
		allMask = (1 << N) - 1;
		
		W = new int[N][N];
		dp = new int[N][allMask];
		
		
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이
		System.out.println( tsp(0, 1) );
	}
	//idx 도시 부터 아직방문하지 않은 남은 모든 도시를 방문하는 최소비용을 반환한다.
	static int tsp(int idx,int mask) {
		
		//기저조건
		if(mask == allMask) {// 모두 방문한 경우
			if(W[idx][0] == 0) return INF;//되돌아 가는 길이 없으므로 해당 경로는 안된다/
			else return W[idx][0];//되돌아가는 비용을 반환해 준다.
		}
		
		//이미 계산된 값이 있다면
		if(dp[idx][mask] != 0) return dp[idx][mask];
		
		//초기비용을 INF로 초기화
		dp[idx][mask] = INF;
		//남은 도시들을 방문하는 최소비용을 계산
		for (int i = 0; i <N; i++) {
			//이동가능한지 ,이미 방문했었는지 확인 , 
			if(W[idx][i] ==0 || (mask & (1<<i)) != 0) continue;
			
			//남은 i를 거치는 비용과 현재비용을 비교하며 최소값 갱신,
			// 남은 i를 거친다. i가 다음 위치, i를 선택해 주었다.+ 비용 추가
			// 방문 가능한 다음 도시(i) 중에서 최소로 가는 경우만 남긴다.
			dp[idx][mask] = Math.min(dp[idx][mask], tsp(i,mask |(1 << i)) + W[idx][i]);
		}
		return dp[idx][mask];
		
	}
	
	


}
// N이 주어진다 16 ! => 20조 : 단순 순열 알고리즘은 시간초과
//DP(memoization) + Bitmasking을 이용한 풀이

//#1 순회
// 순회이므로 사이클이 하나 결정되면 시작점을 어디로하든 비용은 같다 
//     1---2
//    /   /
//   /   4
//  /   /
// 3---5

//#2 비트마스킹으로 현재 방문한 도시를 표현
// - 1010 : 4,2번 도시 방문

//#3 DP 자료구조
// - 2차원 배열
// - dp[i][j] => 현재 i번 도시에 있고, 거쳐온도시들이 j(비스마스킹값 )일때, 남은 도시를 방문하는 최소비용 값을 저장
// - 1,2,3,4,5,6,7 도시가 있을때 dp[3][1100101] => 현재 3번 도시를 방문, 거쳐온도시는 1,3,6,7을 지나왔다.

//  dp[3][1100101]가 미리 계산되었다면, 이후 어떤 순서로 남은 곳을 방문하더라도 이후의 비용은 동일하다(최소비용이기때문에 동일하다)


