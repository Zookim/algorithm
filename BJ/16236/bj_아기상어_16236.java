package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//안됨

public class bj_아기상어_16236 {
	//가장 위 가장 왼쪽
	//몇초동안?
	static int N;
	static int map[][];

	static int dr[] = {-1,0,0,1};
	static int dc[] = {0,-1,1,0};

	// 가장왼쪽 가장 오른쪽의 위치로 먼저간다, 한칸에 1초씩 이동한다
	//큐가 비워지면 종료한다.
	//아기상어와의 거리 -> 맨 위쪽 -> 맨왼쪽// 또한 자신보다 작아야한다. 지나갈수는 있다.
	// 못먹으면 큐에 다시 넣는다.,
	//자신의 크기만큼먹어야 커진다.
	//먹을 수 있는 것만 저장한다,
	static class Shark{
		int r;
		int c; 
		int size=2;
		int eat=0;
		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static Shark shark;
	
	static class Fish{
		int r,c;
		int dis=0;
		int able;
		public Fish(int r, int c, int able,int dis) {
			super();
			this.r = r;
			this.c = c;
			this.able = able;//먹을 수 있는 크기0, 없다면 자기 크기
			this.dis = dis;
		}
		
	}
	static PriorityQueue<Fish> que= new PriorityQueue<>((n1,n2)-> {
		return n1.able == n2.able? (n1.dis==n2.dis? (n1.r==n2.r ? n1.c-n2.c: n1.r-n2.r ) :n1.dis-n2.dis):n1.able-n2.able; //크기순, 거리순
	});//크기순 -> 거리순 -> 먹을 수 있는 크기라면
	
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
		N =  Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				
				map[i][j] =  a;
				if(a == 9) {//상어 위치
					shark =  new Shark(i,j);
					map[i][j]=0;
				}
				
			}
		}
		

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int a = map[i][j];
				if(a > 0) {
					// 거리계산
					int dis = Math.abs(shark.r-i)+Math.abs(shark.c-j);
					if(a ==1) {//먹을수 있다.
						que.offer(new Fish(i,j,0,dis));
						 //map[i][j] = 0;
					}else {
						que.offer(new Fish(i,j,a,dis));
					}

				}

			}
		}


		//입력 완료

		int res=0;
		while(!que.isEmpty()) {
			Fish nowfish = que.poll();//먹을 수 있고 가장가깝다
			//매초가 아니라 이동횟수를 합산한다.
			//정렬했는데도 먹을 수 없는 것이 나오면 끝
			if(nowfish.able != 0) {break;}
			
			int bfsvalue = bfs(nowfish);
			if(bfsvalue == -1) break;
			
			res += bfsvalue;
	
			System.out.println(shark.r +" "+shark.c+" res "+res+" size "+(shark.size));
			print();
		}
		
		System.out.println("res "+ res);

	}
	static void print() {
		for(int a[]:map) {
			System.out.println(Arrays.toString(a));
		}
	}
	static int bfs(Fish nowfish) {//map과 nowfish.dis, 상어의 위치를 기반으로 최단거리를 구한다.
		//막혀있다면 -1출력
		int endr = nowfish.r;
		int endc = nowfish.c;
		int num=0;
		Queue<int []>tmp2 = new ArrayDeque<>();
		boolean visit[][] = new boolean[N][N];
		visit[shark.r][shark.c] =true;//시작점
		tmp2.offer(new int[] {shark.r,shark.c});

		while(!tmp2.isEmpty())	{
			
			int size = tmp2.size();
			//System.out.println(size);
			for(int j =0;j<size;j++) {
				int [] now = tmp2.poll();
				int r = now[0];
				int c = now[1];
				if(r == endr && c == endc) {//잡았다.
					
					resetshark(nowfish.r,nowfish.c);
					resetdis();
					
					map[endr][endc] =0;
					return num;
					} 

				
				
				//만약 이동중에 더 가까워진 먹을수있는 고기가 있었다면
				if( map[r][c]>0 && map[r][c] < shark.size) {
					que.offer(nowfish);
					map[r][c] =0;//잡았다.
					resetshark(r,c);
					resetdis();
					que.poll();
					
					return num++;
					
				}
				for(int i=0;i<4;i++) {
					int row = r+dr[i];
					int col = c+dc[i];
					if(row < N && row>=0 && col < N && col>=0 &&!visit[row][col] && map[row][col] <= shark.size) {
						tmp2.offer(new int[] {row,col});
						visit[row][col] = true;
					}
				}
			}
			num++;//한 칸을 움직였다.
		}
		return -1;//도달하지 못함
	}
	//상어가 이동하면 거리갱신
	static void resetshark(int r,int c) {
		shark.r = r;
		shark.c=c;
		shark.eat++;
		if(shark.eat == shark.size) {
			shark.eat=0;
			shark.size++;
		}
		
	}
	
	static Queue<Fish>tmp = new ArrayDeque<>();
	static void resetdis() {

		while(!que.isEmpty()) {
			Fish now = que.poll();
			int able = now.able;
			
			now.dis =  Math.abs(shark.r-now.r)+Math.abs(shark.c-now.c);
			if(able < shark.size) {
				now.able=0;
			}
			tmp.offer(now);
			
		}
		while(!tmp.isEmpty()) {
			Fish now = tmp.poll();
			que.offer(now);
			
		}
		

	}

	

}
