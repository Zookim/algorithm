package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_뱀_3190 {
	// 뱀이 자신의 몸이나 벽에 부딪히는 경우 게임을 끝낸다.
	static int map[][];
	static int N,K,L;
	static int apple[][];
	static int direct[][];

	//시계방향                                L<- -> D
	static int dr[] = {0,1,0,-1,0,1,0,-1,0,1,0,-1};//우측, 하단, 좌측, 상단 
	static int dc[] = {1,0,-1,0,1,0,-1,0,1,0,-1,0};//우측, 하단, 좌측, 상단 
	static int dir_len = dr.length;
	
	static Deque<int[]> snake = new ArrayDeque<>();
	
	// 1 뱀,0 빈칸 , 2 사과
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 2;
		}
		
		
		L = Integer.parseInt(br.readLine());
		direct = new int[L][2]; // 방향 전환 정보를 저장한다.
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			direct[i][0] = Integer.parseInt(st.nextToken());
			String a = st.nextToken();
			if(a.equals("D")) { //오른쪽 1
				direct[i][1] =1;
			}else {
				direct[i][1] =0; //왼쪽 0
			}
			
		}
		
		//입력끝
		// 배열위에 움직임을 기록한다. 이를 토대로 벽과 만나는지 자기몸통 visit과 만나는지 확인한다.
		//0,0에서 0,1으로 
		//사과는 배열위에표시
		// 방향은 DEque 아님 배열...
		
		//초기 상태
		map[0][0]=1; //뱀의 몸통 표시
		
		// 뱀의 전체 위치
		snake.offerFirst(new int[] {0,0});
		
		int dir_index=0; // 현재 방향을 저장하고 있다.
		int cnt=0;
		int index_direct=0; //  direct의 몇번째를 확인해야하는지를 저장하고 있따.
		
		while(true) {
			// 방향을 고려해서 -> 변화하는 시간인지 체크 
			if(index_direct < L && cnt == direct[index_direct][0]) { //방향을 전환해야한다면
				
				if(direct[index_direct][1] == 1) { //오른쪽이라면
					dir_index++;
					if(dir_index == dir_len) {
						dir_index=0;
					}
				}else {
					dir_index--;
					if(dir_index == -1) {
						dir_index=dir_len-1;
					}
				}
				index_direct++;
			}
			//방향을 전환할 필요가 없다면
			// 머리 이동 머리에 몸통이 겹치는지, 사과가 있는지 벽을 만나는지 확인
			int nowhead[] = snake.getFirst(); //꺼내진 않고 보기만 한다.
			int h_r = nowhead[0] + dr[dir_index];
			int h_c = nowhead[1] + dc[dir_index];
			if(h_r < 0 || h_r >=N || h_c < 0|| h_c >=N || map[h_r][h_c] == 1) { //벽을 만난 경우, 몸통을 만난경우
				cnt++; //현재 시간에 벽을 만났다.
				break;
			} 
			
			if(map[h_r][h_c] != 2) { // 사과가 없다면 꼬리를 버린다.
				int nowtail[] = snake.pollLast();
				map[nowtail[0]][nowtail[1]]=0;
			}
			//머리 추가 
			map[h_r][h_c] = 1;
			snake.addFirst(new int[] {h_r,h_c});

			cnt++;
			System.out.println(cnt);
			print();
			
		}
		
		System.out.println(cnt);
		
		
		
	}
	
	static void  print() {
		for(int a[] :  map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
