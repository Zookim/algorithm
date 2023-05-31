package algo_live.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class sw_점심식사시간_2383 {
	//사람들이 아래층으로 이동하는 시간은 계단 입구까지 이동 시간과 계단을 내려가는 시간이 포함된다.
	static int N,cnt,ans;
	static final int M =1,W =2,D =3,C =4; //이동중, 대기,내려가는 중, 완료
	static class Person implements Comparable<Person>{
		int r,c,arrivalTime,downCnt,status;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public void init() {
			arrivalTime = downCnt =0;
			status = M;
		}
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}
		
		
	}
	
	
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<Person>();
			sList = new int[2][];
			ans = Integer.MAX_VALUE;
			
			StringTokenizer st = null;
			
			for(int i=0,k=0 ;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					int c = Integer.parseInt(st.nextToken());
					if(c==1) {
						pList.add(new Person(i,j));
					}else if(c>1) {
						sList[k++] = new int[] {i,j,c}; 
					}
				}
			}
			
			cnt = pList.size();
			selected = new int[cnt]; //선택한 계단 인덱스
			//모든 사람에게 계단을 배정
			divide(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	//Power Set
	static void divide(int index) {
		if(index == cnt) {
			int res = go();
			if(ans > res) ans = res;
			return;
		}
		//계단 0선택
		selected[index] =0 ;
		divide(index+1);
		//계단 1선택
		selected[index]=1;
		divide(index+1);
		
	}
	//선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리후 소요된 시간 리턴
	static int go() {
		ArrayList<Person>[] list = new ArrayList[] {new ArrayList<Person>(), new ArrayList<Person>()};
		
		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			p.init(); // 상태를 초기화 한다.여러번 계산하므로 필요
			int no = selected[i]; // 배정된 계단
			p.arrivalTime = Math.abs(p.r-sList[no][0]) +  Math.abs(p.c-sList[no][1]); 
			//해당 계단에 도착할 시간을 구한다. 
			list[no].add(p);
		}
		int timeA =0,timeB=0;
		if(list[0].size() >0) {
			timeA = processDown(list[0],sList[0][2]);
		}
		if(list[1].size() >0) {
			timeB = processDown(list[1],sList[1][2]);
		}
		return timeA > timeB ? timeA : timeB;
	}
	
	static int processDown(ArrayList<Person> list,int height) {
		Collections.sort(list);
		int time = list.get(0).arrivalTime;
		int size = list.size();
		
		int ingCnt =0,cCnt=0;
		Person p = null;
		while(true) {
			for(int i=0;i<size;i++) {
				p = list.get(i);
				
				if(p.status == C) {
					continue;
				}else if(p.arrivalTime ==  time) {
					p.status = W;
				}else if(p.status == W && ingCnt<3) { // 기다렸다면 계단이 빌때 내려준다.
					p.status = D;
					p.downCnt = 1;
					ingCnt++;
				}else if(p.status == D) {
					if(p.downCnt == height) { // 도착했다.
						p.status = C;
						ingCnt--; // 계단을 사용하고 있는 사람의 수
						cCnt++; // 계단을 모두 내려간 사람의 수
					}else {// 아직 도착하지 못했다.
						p.downCnt++;
					}
				}
			}
			
			if(cCnt == size) break;
			time++;
			
		}
		return time;
	}

}
