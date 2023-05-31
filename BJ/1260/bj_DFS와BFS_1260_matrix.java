package algo.wk5;
//잘나온다
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_DFS와BFS_1260_matrix {
//1.인접 행렬
	static boolean arr[][];
	static int N,M,V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new boolean [N+1][N+1]; // 각행의 첫열을 visit로 사용한다.
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			//양방향이므로
			arr[start][end] = true;
			arr[end][start] = true;
		}
		
		dfs(V);
		sb.setCharAt(sb.length()-1, '\n'); // index위치의 문자를 교체한다
		
		//visit를 기록하는 것을 초기화
		for(int i=1;i<=N;i++) {
			arr[i][0]=false;
		}
		
		bfs(V);
		//sb.setLength(sb.length() -1);
		System.out.println(sb);

	}
	static void dfs(int n){
		sb.append(n).append(" ");
		arr[n][0] =true;
		//여기까지 현재위치에서 해야할일
		//아래가 다음으로 가기위한 준비
		for(int i=1;i<=N;i++) {
			if(!arr[n][i] || arr[i][0]) continue; //갈수 없거나, 방문한 정점은 제외
			dfs(i);
		}

	}
	static void bfs(int n){
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(n);
		arr[n][0] = true; //넣을때 예약걸어준다
		
		while(!que.isEmpty()) {
			//현재위치에서 해야할것
			int now = que.poll();
			sb.append(now).append(" ");
			for(int i=1;i<=N;i++) {
				if(arr[i][0] || !arr[now][i])continue; 
				que.offer(i);
				arr[i][0] = true;

			}
		}
		

	}

}
