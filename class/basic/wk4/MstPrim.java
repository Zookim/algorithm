package basic.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MstPrim {
//정점을 이동
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];
		boolean[] visited = new boolean[N];

		int[] minEdge = new int[N]; //minEdge[3] =>3번 정점에서 갈수 있는 최소비용이 10이다

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE; //=>얘 대신에 우선순위큐를 사용한다.
		}
		//Mst 찾기 시작
		// 0번 정점부터

		int minVertex,min,result =0;
		minEdge[0] = 0; //다른 정점의 최소비용은 모두 Max

		for (int c = 0; c < N; c++) { //모든 정점의 수만큼 반복
			//초기화
			min = Integer.MAX_VALUE;
			minVertex = 0;

			//모든 정점(남은 정점) 중에서 미방문이면서, 비용이 가장작은 것을 
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min> minEdge[i]) {
					min = minEdge[i];
					minVertex =i;
				}
			}
			//최소비용의 정점을 선택
			visited[minVertex] = true;
			result += min;

			//선택한 정점으로부터 다시 minEdge[] 갱신 <= minEdge의 현재값하고 minVertex를 고려한 값을 비교해서 저 적은 비용으로
			//1.아직 선택되지 않은 정저
			//2.현재 선택된 최소비용의 정점으로부터 갈수 있는 다음 정점
			//3.현재 minEdge[i] 보다 minVertex에서 i로 가는 비용이 더 싸면 갱신
			for (int i = 0; i < N; i++) {
				if(!visited[i] && input[minVertex][i] !=0 && minEdge[i] > input[minVertex][i]) {
					minEdge[i] = input[minVertex][i];
				}
			}

		}
		System.out.println(result);

	}
}
