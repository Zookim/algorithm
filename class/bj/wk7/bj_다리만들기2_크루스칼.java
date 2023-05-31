package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 크루스칼 : 간선 중심 <= 간선 정렬후(간선이 적어야 유리) , 최소 간선을 선택해 ㅅ가면서 (사이클이발생하지 않도록) 정점의 수-1 개를 선택한다.
public class bj_다리만들기2_크루스칼 {


	static int N,M,min,landnum;
	static int map[][];
	static boolean visit[][];
	
	static int [] dr =  {-1,1,0,0};
	static int [] dc =  {0,0,-1,1};
	
	static int V; //정점의 수
	static int adjmatrix[][];
	
	static class Edge{
		int v1,v2,cost;

		public Edge(int v1, int v2, int cost) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		
		
	}
	static PriorityQueue<Edge> pque = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost); // 작은 비용이 먼저 오도록
	
	//cycle
	static int[] parent;
	static void makeSet(int num) {
		for (int i = 1; i <=num; i++) {
			parent[i] =i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px == py) return false;
		if(px <py) parent[py] = px; // 수가 더큰쪽에 넣도록한다.
		else parent[px] = py;
		return true;
	}
	
	static final int INF=999; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map =  new int[N][M];
		visit =  new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력끝
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j]==1) { //방문했거나 0인곳은 고려하지 않는다.
					bfs(i,j);
				}
			}
		}
		//print(); //완료

		//행렬 만들기
//		
//		for(int i=0;i<landnum;i++) { // 섬의 수만큼 만든다, 대칭적이다.
//			adjlist.add(new ArrayList<Edge>());// i에서 출발하는 간선의 도착지와 다리길이를 저장
//		}
//		adjmatrix = new int[landnum+1][landnum+1];
//		for(int i=0;i<=landnum;i++) {
//			Arrays.fill(adjmatrix[i], INF);
//		}
//		
		V = landnum;
		parent = new int [V+1];
		makeSet(V);
		
		// 간선을 파악해 자료 구조에 저장, 우선순위 큐에 저장
		hr();
		vr();
		
		
		//쿠르스칼 적용
		int cnt =0;
		while(!pque.isEmpty()) {
			Edge e = pque.poll();
			if(union(e.v1,e.v2)) { //하나 연결
				min += e.cost;
				cnt++;
			}
			
			if(cnt == V-1) break;
		}
		if(cnt != V-1) {
			min = -1;
		}
		System.out.println(min == 0 ? -1 : min);
		
		

	}
	static void addEdge(int v1, int v2, int cost) {
	    
	    boolean same = false;
	    
	    for (Edge edge : pque) {
	        if( edge.v1 == v1 && edge.v2 == v2 ) {
	            same = true;
	            edge.cost = Math.min(edge.cost, cost);
	            break;
	        }
	    }

	    if( ! same ) pque.offer(new Edge(v1, v2, cost));
	}
	static void vr() {
	    
	    for (int i = 0; i < M; i++) { // hr() 대비 N, M 반대로
	        int prev = 0;
	        int curr = 0;
	        int v1 = 0;
	        int v2 = 0;
	        int cost = 0;
	        for (int j = 0; j < N; j++) { // hr() 대비 N, M 반대로
	            curr = map[j][i]; // hr() 대비 i, j 반대로
	            if( prev == 0 && curr != 0 ) {
	                if( v1 == 0 ) v1 = curr;
	                else {
	                    // edge 발생
	                    v2 = curr;
//	                        System.out.println(v1 + "---" + v2 + " : " + cost );
	                        if( cost > 1 ) {
	                            addEdge(v1, v2, cost);
	                            //addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
	                        }
	                        v1 = v2;
	                        v2 = 0;
	                        cost = 0;
	                    }
	                }else if( v1 != 0 && curr == 0 ) {
	                    cost++;
	                }

	                prev = curr;
	            }
	        }
	    }
	static void hr() {
		for (int i = 0; i < N; i++) {
			int prev = 0;
			int curr=0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			for (int j = 0; j < M; j++) {
				curr= map[i][j];
				if(prev ==0 && curr !=0) { //바다 -> 섬
					if(v1 ==0) v1 = curr;
					else {
						v2 = curr;
						if(cost > 1) {
							addEdge(v1, v2, cost);
							//addEdge
						}
						v1 = v2;
						v2 =0;
						cost = 0;
					}
				}else if(v1 != 0 && curr ==0) {
					cost++;
				}
				 prev = curr;
			}
		}
	}
	
	static void findNextLand(int num,int r,int c) {
		System.out.println(num);
		//해당위치에서 벽이나 다음섬, 자기땅을 만날때까지 탐색한다., 사방탐색
		for(int i=0;i<4;i++) {
			int drp = dr[i];
			int dcp = dc[i];
			int row = r;
			int col = c;
			int cnt=0;
			while(row >=0 && col >=0 && col < M && row < N && map[row][col] == 0) {
				cnt++;
				row += drp;
				col += dcp;
			}
			//무엇을 만났는지
			int next = map[row][col];
			System.out.println("next " + next);
			if(row <0 ||col <0 ||col >=M || row >= N ) continue; // 범위 초과시
			
			else if(next != num) { // 자신은 아니면서 다른땅을 만났을때
				
				if(adjmatrix[num][next] > cnt && cnt > 1) {
					//System.out.println(cnt);
					adjmatrix[num][next] = cnt;
					adjmatrix[next][num] = cnt;
				}
			}
			
		}
	}
	
	
	static ArrayDeque<int[]> que =  new ArrayDeque<>();
	static void bfs(int startr,int startc) {
		landnum++;
		que.offer(new int[] {startr,startc});
		
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r= now[0];
			int c= now[1];
			
			visit[r][c]=true;
			map[r][c] = landnum;
			
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];
				if(row <0 ||col <0 ||col >=M || row >= N || map[row][col]==0 || visit[row][col]) continue; //범위내에 있으면서 1이면 큐에 넣는다;
				que.offer(new int[] {row,col});
			}

		}


	}
	static void print() {
		for(int a[]: map) {
			System.out.println(Arrays.toString(a));
		}
	}
	static void printAdj() {
		for(int a[]: adjmatrix) {
			System.out.println(Arrays.toString(a));
		}
	}

}
