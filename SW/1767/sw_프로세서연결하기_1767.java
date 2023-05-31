package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class sw_프로세서연결하기_1767 {
	
	//최대한 많은 코어에 전원을 연결하는 경우 전선길이의 합, 전선은 모두 직선
	//1.최대한 많은 코어를 선택 ->2.그중에서 전선의 길이가 최소가 되도록
	
	//최단경로, 단 직선으로 서로 만나지 않게
	static int N;
	static int path;
	static int map[][];
	static boolean select[];
	static int totalmin;
	static class Core{
		int r;
		int c;
		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int CoreNum;
	static List<Core> corelist = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case=1; test_case<=T;test_case++) {
			permmin = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map =new int[N][N];
			corelist.clear(); ; //매 테스트 케이스에 대해 초기화
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && !(i==0||i==(N-1)||j==0||j==(N-1))) { //가장자리의 것은 예외
						corelist.add(new Core(i,j));
					}
					
				}
			}
			
			
			CoreNum = corelist.size();
			//System.out.println(CoreNum);
			for(int i=CoreNum;i>=0;i--) {
				select = new boolean[CoreNum];
				totalmin = Integer.MAX_VALUE;
				comb(i,0,0);// 수가 많은 것부터 센다.
				if(totalmin != Integer.MAX_VALUE) {
					break;
				}
				//코어의 수가 작아진다.
			}
			System.out.println("#"+test_case+" "+totalmin);
		}
	}
	
	
	static void comb(int len,int index,int start) {
		if(index ==len ) {
			
			preperm(len);
			perm(len,0);//최단경로를 구하기위해 선택하는 순서를 다르게한다.
			//bfs();// 현재조합이 가능한지 , 가능하면 최단경로는 몇인지 반환
			//여기서 최소값이, 각갯수를 선탠한 경우의 최간경로, 이값이 결과값이 된다.
			if(totalmin > permmin) {
				totalmin = permmin;
			}
			return;
			
		}
		
		
		for (int i = start; i < CoreNum; i++) {
			select[i] = true;
			comb(len,index+1,i+1);
			select[i] = false;
		}
	}
	
	static boolean pselect[];
	static int parr[],parray[];
	static int[][] newmap;
	static int permmin = Integer.MAX_VALUE;
	
	static void perm(int len,int index) {
		if(index == len) {
			
			path=0; 
			reset();//각 판마다 newmap초기화
			//이번 판의 최소경로
			for(int i=0;i<len;i++) {
				int res = bfs(i);
				
				if(res == 2*N) {
					path=Integer.MAX_VALUE;
					System.out.println("fail");
					return;
				}else {
					path += res;
					
					if(path > permmin) {
						path=Integer.MAX_VALUE;
						return;
					}
				}
				
			}
			//이번판의 최소경로
			permmin = path;
			System.out.println(Arrays.toString(parr));
			//System.out.println(Arrays.toString(parr));
			return;
		}
		for(int i=0;i<len;i++) {
			if(pselect[i])continue;
			pselect[i]=true;
			parr[index] = parray[i];
			perm(len,index+1);
			pselect[i]=false;
		}
		
	}
	static void reset() {
		newmap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				newmap[i][j] = map[i][j];
			}
		}
	}
	
	static int bfs(int num) { //그냥 최단경로만을 구한다.
		Core now = corelist.get(parr[num]);
		int shorpath=0;
		int r = now.r;
		int c = now.c;
		int up=r -1;
		int down=r+1;
		int left=c-1;
		int right=c+1;
		int dir=0;
		

		boolean no_up = false;
		boolean no_down = false;
		boolean no_right = false;
		boolean no_left = false;
		//System.out.println(r+" "+c);
		while(true) {

			if(up >= 0 && newmap[up][c]==1 ) {no_up = true;}
			if(down <= N-1 && newmap[down][c]==1 ) {no_down = true;}
			if(left >= 0 && newmap[r][left]==1 ) {no_left = true;}
			if(right <= N-1 && newmap[r][right]==1 ) {no_right = true;}
			
			if(no_up && no_down && no_left && no_right) {return 2*N;}//없는경우
			
			if( up < 0 && !no_up) {//상
				break;
			}else if( down > N-1 && !no_down) {//하
				dir=1;
				break;
			}else if( left < 0 && !no_left ) {//좌
				dir=2;
				break;
			}else if( right > N-1 && !no_right) {//우
				dir=3;
				break;
			}
			
			
			up += -1;
			down += 1;
			left +=-1;
			right += 1;
			shorpath++;
		}
		int res = shorpath;
		//System.out.println("shorpath "+shorpath);
		if(dir==0) {
			while(shorpath!=0) {
				newmap[r-shorpath][c]=1;
				shorpath--;
			}
		}else if(dir==1) {//하
			while(shorpath!=0) {
				newmap[r+shorpath][c]=1;
				shorpath--;
			}
		}else if(dir==2) {//좌
			while(shorpath!=0) {
				newmap[r][c-shorpath]=1;
				shorpath--;
			}
		}else if(dir==3) {//우
			while(shorpath!=0) {
				newmap[r][c+shorpath]=1;
				shorpath--;
			}
		}
		
		
		
		return res;
		
	}
	
	
	
	static void preperm(int len){ //매번 초기화
		pselect = new boolean[len];
		parr = new int[len];//순서 결과저장
		parray = new int[len];// 사용한 프로세스 번호저장
		int in=0;
		for(int i=0;i<CoreNum;i++) {
			if(!select[i]) continue;
			parray[in] = i;
			in++;
		}
		
		
		
	}

	
	static void print() {
		for(int a[]:newmap) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}
	static void print2() {
		for(int i=0;i<CoreNum;i++) {
			if(select[i]) {
				System.out.print(i+" ");
			}
			
		}System.out.println();
	}
	
}
