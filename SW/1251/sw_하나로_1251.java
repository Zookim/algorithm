package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_하나로_1251 {
	//비용을 최소로하며 거리를 선택 -> 최소신장트리
	//2.프림 - 정점기준으로
	
	static int N;
	static double E;
	static BigDecimal E2;
	static long matrix[][];
	static Island[] land;
	static boolean visit[];
	static PriorityQueue<List> que = new PriorityQueue<>(new Comparator<List>() {

		@Override
		public int compare(List o1, List o2) { //오름차순 정렬
			if(o1.cost > o2.cost) return 1;
			else if(o1.cost < o2.cost) return -1;
			else return 0;
		}
		
	});
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stx;
		StringTokenizer sty;
		
		int T= Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case <= T;test_case++) {
			N = Integer.parseInt(br.readLine());
			matrix = new long[N][N];
			land = new Island[N];
			visit = new boolean[N];
			
			stx = new StringTokenizer(br.readLine());
			sty = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {//정점번호는0번부터
				int a = Integer.parseInt(stx.nextToken());
				int b = Integer.parseInt(sty.nextToken());
				land[i] = new Island(a,b);
			}
			E = Double.parseDouble(br.readLine());
			E2 = new BigDecimal(String.valueOf(E));
			//프림
			//1.첫정점선택, 해당 정점과 연결되는 것중 비용이 가장적은 정점선택,
			//다음정점에 대해 이를 반복
			
			//첫정점 선택
			que.clear();
			int count=1;
			visit[0] = true;
			int no = 0;
			double total =0;
			while(true) { // 
				
				int nowx = land[no].x;
				int nowy = land[no].y;
				for(int i=1;i<N;i++) {//첫번째는 이미 선택했으므로
					if(!visit[i]) {//아직 방문전일때, 나와의 거리를 다시 비교
						int x = land[i].x;
						int y = land[i].y;
						que.offer(new List(no,i,cost(nowx,nowy,x,y)));//이전것이 더 작은게 있다면 그걸 선택
					}

				}
				//가장 경로가 작은게 나온다.
				List now = que.poll();
				while(visit[now.no]) { //이미 방문한것은 버려야한다.
					now = que.poll();
				}
				visit[now.no] = true;
				no =  now.no;
				//System.out.println(now.from + " "+no + " " +now.cost);
				total += now.cost;

				if(++count == N) {break;}//정점 수 만큼 선택 완료

			}
			System.out.println("#"+test_case+" "+Math.round(total));
			
		}
		
	}

	static class List{// implements Comparator<List>{
		int from;
		int no;
		double cost;
		public List(int from, int no, double cost) {
			super();
			this.from = from;
			this.no = no;
			this.cost = cost;
		}
	}
	static class Island{
		int x,y;
		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static double cost(int x1, int y1,int x2,int y2) {
		double x = Math.abs(x1-x2);
		double y = Math.abs(y1-y2);
		
//		BigDecimal x11 = new BigDecimal(String.valueOf(x));
//		x11.multiply(x11);
//		BigDecimal y11 = new BigDecimal(String.valueOf(y));
//		y11.multiply(y11);
//		x11.add(y11);
//		x11.multiply(E2);
//		
//		double res = x11.doubleValue();
//		return Math.round(res);
		//System.out.println(Math.abs(x*x+ y*y) * E);

		//return (long) Math.round((x*x+ y*y) * E);
		return (x*x+ y*y) * E;
	}
}
