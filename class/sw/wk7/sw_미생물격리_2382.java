package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class sw_미생물격리_2382 {
	
	static int N,M,K;
	static int things[][];
	static int map[][];
	
	static int dr[] = {0,-1,1,0,0}; //dummy
	static int dc[] = {0,0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			
			things = new int[K+1][4];//dummy
			for(int i=1;i<=K;i++) {
				st = new StringTokenizer(br.readLine());
				things[i][0] = Integer.parseInt(st.nextToken()); //r
				things[i][1] = Integer.parseInt(st.nextToken()); //c
				things[i][2] = Integer.parseInt(st.nextToken()); //num
				things[i][3] = Integer.parseInt(st.nextToken()); //dir
				
				
			}
			
			//약품이 있는 곳으로 이동하는 경우 -> 방향이 전환된다.(약풍이 있는 곳에서 군집들이 처음으로 만나게 되는 경우는 없다.)
			//(모두 한칸씩 이동하므로, 군집들이 만나는 경우는 교차하는 경우 밖에 없다.)
			//군집이 서로 만나는 경우 -> 군집이 사라지고, 합쳐진다.
			for(int hour=0;hour<M;hour++) { //M시간 동안 이동시킨다.
				//맵은 매시간마다 초기화한다. 각 순간에만 확인하면 되므로
				map = new int[N][N];
				List<PriorityQueue<int[]>> que = new ArrayList<>();
				que.add(new PriorityQueue<int[]>());
				for(int i=0;i<K;i++) {
					que.add( new PriorityQueue<int[]>((e1,e2) -> e2[1] - e1[1]) ); //내림차순
				}
				for(int i=1;i<=K;i++) {
					
					int r = things[i][0];
					if( r== -1) continue;
					
					int c = things[i][1];
					int num = things[i][2];
					int dir = things[i][3];
					
					r += dr[dir];
					c += dc[dir];
					//약품에 도달했으면 방향을 전환한다.
					if(r==0 || c==0 ||r==(N-1) || c==(N-1)) {
						things[i][2] = num/2; //!!!!!1.
						switch(dir) { //방향을 전환해준다.
						case 1:
							things[i][3] = 2;
							break;
						case 2:
							things[i][3] = 1;
							break;
						case 3:
							things[i][3] = 4;
							break;
						case 4:
							things[i][3] = 3;
							break;
							
						}
					}
					things[i][0] = r;
					things[i][1] = c;
					
					//만약 map의 이동한 위치에 자신보다 작은 index를 가진 군집이 있다면 겹치는 것이므로 조정한다.
					int now = map[r][c];
					if(now !=0) { 
						// 만약 3개이상이 만나면 가장 큰경우를따라야하므로 동시에 고려해야한다.
						//군집의 수만큼 큐 배열을 사용한다.
						//처음으로 해당 점을 가지는 군집의 index룰 맵에 기록해 놓고 ,이후에 동일한
						//곳을 방문 하는 군집이 있다먄 이 인덱스 번호의 큐를 방문한다.
						// 단 큐는 군집수가 가장먼저 poll되도록 정렬한다.
						que.get(now).offer(new int[] {i,things[i][2]});
						//System.out.println(que.get(now).peek()[0]);
//						if(things[i][2] < things[now][2]) { //이전것이 더 크다면
//							things[i][0] = -1;
//							things[now][2] += things[i][2];
//						}else {
//							things[now][0] = -1;
//							things[i][2] += things[now][2];
//							map[r][c] = i;
//						}
					}else {//0이라면
						que.get(i).offer(new int[] {i,things[i][2]});
						map[r][c] = i;
					}
					
					
					
					
				}//for
				// 각 군집을 이동시킨다.
				//map에 군집의 index를 기록하여 이동후!에 군집이 만나는경우 큰것의 값에 군집수를 합쳐주고 
				//작은 것은 r을 -1로 바꾸어준다.
				
				//큐를 돌며 가장큰 군집만 남긴다.
				
				for(int s=1;s<=K;s++) {
					
					if(que.get(s).isEmpty()) continue;
					else {
						int n = que.get(s).poll()[0];//
						
						while(!que.get(s).isEmpty()) {
							
							int n2 = que.get(s).poll()[0];
							things[n][2] += things[n2][2];
							things[n2][0] = -1;
							
						}
					}
				}
				
				print();
				printthings();
			}//end
			int sum =0;
			for(int i=1;i<=K;i++) {
				if(things[i][0] == -1) continue;
				sum += things[i][2];
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			
			
			
			
		}
		System.out.println(sb);

	}
	static void printthings() {
		for(int i[] :things) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}
	static void print() {
		for(int i[] :map) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

}
