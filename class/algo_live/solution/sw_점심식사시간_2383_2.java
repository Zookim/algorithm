package algo_live.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sw_점심식사시간_2383_2 {
	//사람들이 아래층으로 이동하는 시간은 계단 입구까지 이동 시간과 계단을 내려가는 시간이 포함된다.
	static int N,cnt,ans;
		static class Person implements Comparable<Person>{
		int r,c,arrivalTime;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
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
		int size = list.size()+3;
		int[] D = new int[size]; //나보다 3번째 앞에 있는 사람의 도착 시간을 본다.(i-3 <- i),dummy
		for (int i = 3; i < size; i++) {
			Person p = list.get(i-3); // 각 사람들의 도착시간을 저장한다.
			
			if(D[i-3] <= p.arrivalTime+1) { // 대기할 필요가 없을 경우(기본대기 시간 외의) 예상완료시간을 구한다.
				D[i] = p.arrivalTime+1+height;// 이사람의 예상 완료시간
			}else {
				D[i] = D[i-3]+height;
			}
		}
		return D[size-1]; //모든 사람이 내려갔을때의 시간
	}

}
