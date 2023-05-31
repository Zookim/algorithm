package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_무산충전_5644 {
//성공
	static int A[][],B[][];
	
	static class Charge {//implements Comparable{

		int r;
		int c;
		int range;
		int perfor;
		
		public Charge(int x, int y, int range, int perfor) {
			super();
			this.r = x;
			this.c = y;
			this.range = range;
			this.perfor = perfor;
		}
		
	}
	
	static Charge [] bcList;
	static boolean range[][];
	static int BC,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int test_case =1;test_case <= T; test_case++) {
			int total=0;
			StringTokenizer st= new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			BC = Integer.parseInt(st.nextToken()); // 충전기의 수
			range = new boolean [2][BC];
			
			
			
			//사용자의 이동 경로
			A = new int [M+1][2]; //(1, 1) , 초기위치에선 충전 못함
			st= new StringTokenizer(br.readLine());
			int [] starta = {0,0};
			A[0][0] = 0;
			A[0][1] = 0;
			for(int i=1;i<=M;i++) {
				int a = Integer.parseInt(st.nextToken());
				move(starta,a);
				A[i][0] = starta[0];
				A[i][1] = starta[1];
				
			}
			
			B = new int [M+1][2]; // (9, 9)출발
			st= new StringTokenizer(br.readLine());
			int [] startb =  {9,9};
			B[0][0] = 9;
			B[0][1] = 9;
			for(int i=1;i<=M;i++) {
				int a = Integer.parseInt(st.nextToken());
				move(startb,a);
				B[i][0] = startb[0];
				B[i][1] = startb[1];
			}
			// 0,1상,2우,3하,4좌
			
			//BC의 정보들
			bcList = new Charge[BC];
			for(int i=0;i<BC;i++) {
				st= new StringTokenizer(br.readLine());
				int x =  Integer.parseInt(st.nextToken())-1;
				int y =  Integer.parseInt(st.nextToken())-1;
				int range =  Integer.parseInt(st.nextToken());
				int perfor =  Integer.parseInt(st.nextToken()); // 짝수\\
				
				bcList[i] = new Charge(y,x,range,perfor);
			}
			
			//입력
			int index=1;
			for(int i=0;i<=M;i++) {
				//해당위치가 범위에 포함되는지 나타내는 boolean 수정
				Range(A[i],0);
				Range(B[i],1);
				
				
				int max = Integer.MIN_VALUE;
				for(int j =0;j<BC;j++) {
					for(int k =0;k<BC;k++) {
						int sum;
						int pa=0;
						int pb=0;
						int a= -1;
						int b= -2;
						if(range[0][j]) {pa= bcList[j].perfor;a=j;}
						if(range[1][k]) {pb= bcList[k].perfor;b=k;}
						
						if(a==b) {
							sum =bcList[j].perfor;
						}else {
							sum = pa+pb;
							//System.out.println("s "+sum);
						}
						max = max > sum ? max:sum;
					}
					//System.out.println(max);
					
				}
				//System.out.println(max);
				
				total += max;// 자리이동
				//System.out.println(total + " #"+ index++);
				

			}
			System.out.println("#"+test_case+ " "+total);
			
		}

	}
	static void Range(int [] D,int a) { //rangeA[j]들을 결정한다.,현재위치
		int r = D[0];
		int c = D[1];
		
		for(int i=0;i<BC;i++) {
			int ran = bcList[i].range;
			int R = bcList[i].r;
			int C = bcList[i].c;
			if(Math.abs(R-r) +Math.abs(C-c) <= ran) {
				range[a][i] = true;
			}else {
				range[a][i] = false;
			}
		}
	}
	
	static void move(int [] now,int m) {
		int r =now[0];
		int c =now[1];
		
		switch(m) {
		case 0:
			break;
		case 1: //위로
			if(r-1 >=0) {
				now[0]--;
			}
			break;
		case 2: //우
			if(c+1 < 10) {
				now[1]++;
			}
			break;
		case 3: //하
			if(r+1 <10) {
				now[0]++;
			}
			break;
		case 4: //좌
			if(c-1 >= 0) {
				now[1]--;
			}
			break;
		}
	}
}
