package bj.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_낚시왕_17143 {

	//상어 크기의 합
	//상어의 이동
	
	static class Fish{

		int r;
		int c;
		int speed;
		int direction;
		int size;
		boolean live=true;
		public Fish(int r, int c, int speed, int direction, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
		
	}
	
	static Fish[] fish;
	static int R,C,M;
	static int totalSize;
	static int dy[] = {0,-1,1};
	static int dx[] = {0,0,0,1,-1};
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //1부터 시작
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		fish = new Fish[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r =Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			int s =Integer.parseInt(st.nextToken());
			int d =Integer.parseInt(st.nextToken());
			int z =Integer.parseInt(st.nextToken());
			fish[i] = new Fish(r,c,s,d,z);
			
		}
		//입력
		//C:(0),1,2,3,4,5,6,(7)
		//사람이 C번째에서 물고기를잡으면 끝
		for(int i=1;i<=C;i++) {
			//사람이 이동해서 잡는다.
			//사람이 잡을 수 있는 상어가 있는지 확인
			 getfish(i);
			//있으면 잡는다.
			
			//상어의 이동
			for(int j=0;j<M;j++) {//각상어의 위치응 갱신해준다.
				if(fish[j].live) {
					fishMove2(j);
				}

			}//같은같에 있으면 작은 상어를 제거한다.
			kill();


		}
		System.out.println(totalSize);




	}
	static void kill() { //중복되는 ㄷ것이 있으면 제거
		int arr[][] = new int[R+1][C+1];
		for(int i=0;i<R+1;i++) {
			Arrays.fill(arr[i], 0);
		}

		for(int i=0;i<M;i++) {
			if(fish[i].live) {
				int r = fish[i].r;
				int c = fish[i].c;
				//System.out.println(r+" "+c);
				if(arr[r][c] > 0) {
					int a = arr[r][c];
					int kill = fish[a].size > fish[i].size ? i :a;//더 작은것
					fish[kill].live = false;
					arr[r][c] =kill;
				}
				arr[r][c] = i;
			}
		}
//		for(int a[]: arr) {
//			System.out.println(Arrays.toString(a));
//		}
//		
	}
	static void fishMove2(int n) { //n번째 상어 위치 갱신
		Fish one = fish[n];
		int d = one.direction;
		int r = one.r;
		int c = one.c;
		int s = one.speed;
		
		
		switch(d) { //방향도 바뀌어야한다. !!
		case 1:
		case 2:
			s = s%(R*2-2); //이크기 이상이면 이만큼 제자리에 있다.
			for(int i=0;i<s;i++) {
				if(r==1)d=2; //dy[] = {0,-1,1};아래로,위로
				else if(r==R) d=1;
				r += dy[d];
			}
			fish[n].r = r;
			fish[n].direction = d;
			break;
		case 3:
		case 4:
			s = s%(C*2-2);
			for(int i=0;i<s;i++) { 
				if(c==1)d=3; //dx[] = {0,0,0,1,-1};
				else if(c==C) d=4;
				c+=dx[d];
			}
			fish[n].c = c;
			fish[n].direction = d;
			break;
		
		
		
		}
		
	}

	static void getfish(int i) {

		//System.out.println("asdf "+i);
		int precol=R+1;
		int fishnum=0;
		for(int j=0;j<M;j++) {
			//System.out.println(fish[j].r +" "+fish[j].c);
			if(fish[j].live && fish[j].c == i && fish[j].r < precol) {//가장 위에있는것
				precol =  fish[j].r;
				fishnum=j;

			}
		}
		if(precol !=(R+1)) {// 범위 초과면 없다
			// System.out.println("get "+precol);
			fish[fishnum].live = false;//죽인다.
			totalSize +=fish[fishnum].size;

		}

	}
}
