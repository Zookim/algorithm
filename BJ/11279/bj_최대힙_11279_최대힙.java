package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_최대힙_11279_최대힙{

	public static void main(String[] args) throws Exception{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Mst mst = new Mst();
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			if(now ==0) {
				sb.append(mst.pop()).append("\n");
				
			}else {
				mst.push(now);
			}
//			System.out.println(mst.point);
//			for(int a=0 ;a<16; a++) {
//				System.out.print(mst.list[a] + " ");
//			}
//			System.out.println();
			
		}
		//System.out.println(mst.point +"  "+ Arrays.toString(mst.list));
		//System.out.println(mst.point);
		System.out.println(sb);
	}
	
	static class Mst{
		int [] list = new int [100_002];
		int point = 1;
		
		public void push(int n) {
			//System.out.println("push " + point);
			list[point] = n;
			
			//자식 중에 큰값이 있으면 바꾼다.
			check(point);
			
			point++;
			
			
		}
		public int pop() {
			if(point == 1)return 0;
			
			int res = list[1];
			
			list[1] = list[point-1];
			list[point-1] = 0;
			point--;
			
			check2();
			return res;
		}
		public void check2() {
			int p = 1;
			
			while(p <= point) {
				//System.out.println("p <= point && list[p] < list[p*2]");
				int right;
				if((p*2+1) <= point) {
					right = list[p*2+1];
				}else {
					right = 0;
				}
				//전처리
				
				if((p*2 <= point) && list[p*2] > right) { //큰값과 먼저 비교한다.
					if(list[p] < list[p*2]) {//작으면 바꾼다.
						swap(p,p*2);
						p = p*2;
					}
					else {break;}//자식중 큰값보다 작지 않다면 끝
					
				}else{ //(list[p*2] < list[p*2+1])
					if((p*2 +1<= point) && list[p] < list[p*2+1]) { //다른 마지막 자식과도 비교한다.
						swap(p,p*2+1);
						p = p*2+1;
					}else {break;}
				}
				
			}
			
		}

		public void check(int p) {
			while(p > 1 && list[p] > list[p/2]) {
				//System.out.println("p != 1");

				swap(p,p/2); //자식의 값이 더크다면 서로 바꾼다.
				p = p/2;



			}
		}
		
		public void swap(int p1,int p2) {
			int tmp = list[p1];
			list[p1] = list[p2];
			list[p2] = tmp;
			
		}
	
	}
	
	
}
