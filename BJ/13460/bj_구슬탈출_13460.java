package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_구슬탈출_13460 {
	//10번내에 빼낼 수 있는가
	//동시에빠지면안된다
	//지나가기만하면 빠진다 - 
	//방향와 열도는 행
	
	//열과 행 이동, 가로막히면 멈춤
	//한번에 한칸이 아니라 #이나0,R,B를 만날때까지
	//각자의 이동이 서로 영향을 준다 ->하지만 항상A의 이동을 먼저 고려한다.
	static int N,M;
	static String map[][];
	static Queue<int[]> rque = new ArrayDeque<>();
	static Queue<int[]> bque = new ArrayDeque<>();
	
	static int endr,endc;
	static int count = -1;

	
	static int move[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String [N][M];
		//visit = new boolean[N][M];


		rque.offer(new int[] {-1,-1});
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().split("");
			for(int j=0;j<N;j++) {
				if(map[i][j].equals("R")) {map[i][j]=".";rque.offer(new int[] {i,j});}
				else if(map[i][j].equals("B")) {map[i][j]=".";bque.offer(new int[] {i,j});}
				else if(map[i][j].equals("O")) {endr = i;endc =j;}
			}
			
			
		}
		
		if (bfs()) {
			System.out.println(count+1);
		}else {
			System.out.println(-1);
		}
		

	}
	//A와 B가 같이 뭉직이는 경우 B의 도착위치를 고려해 A의 도착위치를 큐에 저장
	//종료조건, 실패 : 10회 초과일시, 도달 전 큐가 비었을때,
	//성공 : R이 먼저 도달한 경우
	static boolean bfs() {
		System.out.println("asd");
		if(bque.isEmpty())return false; //실패
		if(count ==10) return false; // 실패
			int nowr[] = rque.poll();
			int nowRr = nowr[0];
			int nowRc = nowr[1];
			int nowb[] = bque.poll(); //B의이동을 참조한다.
			int nowBr = nowb[0];
			int nowBc = nowb[1];
			if(nowRr == -1) { //한 층이 끝났다.
				count++;
				int n[] = rque.poll();
				nowRr = n[0];
				nowRc = n[1];
				rque.offer(new int[] {-1,-1});
				
			}
			System.out.println(nowRr+" "+nowRc);
			
			// 같은 열이나 행에 "O"가 있는지 확인
			//A가 먼저빠질지,B가 먼저빠질지
			// A가 먼져 빠져야만 성공
			if(check(nowRr,nowRc) && !check(nowBr,nowBc)) return true;//서로다른 방향일수있으므로 
			//체크해야한다.


			for(int i=1;i<=4;i++) {
				move(nowRr,nowRc,i,nowBr,nowBc); // 다음으로 갈곳, -1이면 버린다.
			}
			
			return bfs();
			

	}
	
	static boolean check(int r,int c) { //사이에 벽이 없고, 같은 열이 나 행이면 true;
		
		if(r == endr) {
			if(c > endc) { // O...R
				while(c >= endr) {
					if(map[r][c].equals("#"))return false;
					c--;
				}
				return true;
			}
			else if(c < endc) {
				while(c <= endr) {
					if(map[r][c].equals("#"))return false;
					c++;
				}
				return true;
			}
			
		}else if(c == endc) {
			if(r >endr) {
				while(r >= endr) {
					if(map[r][c].equals("#"))return false;
					r--;
				}
				return true;
				
			}else if(r <endr) {
				while(r <= endr) {
					if(map[r][c].equals("#"))return false;
					r++;
				}
				return true;
				
			}
		}
		return false; //모두 다르다
		
		
	}
	
	static void move(int Rr,int Rc, int m,int Br,int Bc) { 

		int row = Rr;
		int col = Rc;
		if(m==1) {
			//위로 이동
			int count=0;
			//R이 벽을 만나기 전에 B가 있으면 기억해두었다 한칸뒤로 간다.
			//B가 그 이후나 다른곳에 있음 따로 움직인다.
			while(!map[row][col].equals("#")) {//R이 이동할 위치
				if(row == Br && col ==Bc) {count++;}
				--row;
			}
			if(count ==1) {Br = row;row++;}//사이에 있었으면
			else {//사이에 없었으면
				while(!map[Br][Bc].equals("#") && !(Br == (row+1) && Bc ==col)) {Br--;}
			}

			if(Rr == (row+1)) {return;} //이동하지 않는다.
			else {
				bque.offer(new int[] {Br+1,Bc});
				rque.offer(new int[] {row+1,col});
				return;}
		}
		else if(m==2) {//아래로 이동
			//위로 이동
			int count=0;
			//R이 벽을 만나기 전에 B가 있으면 기억해두었다 한칸뒤로 간다.
			//B가 그 이후나 다른곳에 있음 따로 움직인다.
			while(!map[row][col].equals("#")) {//R이 이동할 위치
				if(row == Br && col ==Bc) {count++;}
				++row;
			}
			if(count ==1) {Br = row;row--;}//사이에 있었으면
			else {//사이에 없었으면
				while(!map[Br][Bc].equals("#") && !(Br == (row-1) && Bc ==col)) {Br++;}
			}
			
			if(Rr == (row-1)) {return;} //이동하지 않는다.
			else {
				bque.offer(new int[] {Br-1,Bc});
				rque.offer(new int[] {row-1,col});
				return;}
		
		}else if(m==3) {
			//좌로 이동
			int count=0;
			//R이 벽을 만나기 전에 B가 있으면 기억해두었다 한칸뒤로 간다.
			//B가 그 이후나 다른곳에 있음 따로 움직인다.
			while(!map[row][col].equals("#")) {//R이 이동할 위치
				if(row == Br && col ==Bc) {count++;}
				--col;
			}
			if(count ==1) {Bc = col;col++;}//사이에 있었으면
			else {//사이에 없었으면
				while(!map[Br][Bc].equals("#") && !(Br == row && Bc ==(col+1))) {Bc--;}
			}

			if(Rc == (col+1)) {return;} //이동하지 않는다.
			else {
				bque.offer(new int[] {Br,Bc+1});
				rque.offer(new int[] {row,col+1});
				return;}
		}else if(m==4) {
			//우로 이동
			int count=0;
			//R이 벽을 만나기 전에 B가 있으면 기억해두었다 한칸뒤로 간다.
			//B가 그 이후나 다른곳에 있음 따로 움직인다.
			while(!map[row][col].equals("#")) {//R이 이동할 위치
				if(row == Br && col ==Bc) {count++;}
				++col;
			}
			if(count ==1) {Bc = col;col--;}//사이에 있었으면
			else {//사이에 없었으면
				while(!map[Br][Bc].equals("#") && !(Br == row && Bc ==(col-1))) {Bc++;}
			}

			if(Rc == (col-1)) {return;} //이동하지 않는다.
			else {
				bque.offer(new int[] {Br,Bc-1});
				rque.offer(new int[] {row,col-1});
				return;}
	}
}




}


