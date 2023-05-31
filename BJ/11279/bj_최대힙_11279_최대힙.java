package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_�ִ���_11279_�ִ���{

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
			
			//�ڽ� �߿� ū���� ������ �ٲ۴�.
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
				//��ó��
				
				if((p*2 <= point) && list[p*2] > right) { //ū���� ���� ���Ѵ�.
					if(list[p] < list[p*2]) {//������ �ٲ۴�.
						swap(p,p*2);
						p = p*2;
					}
					else {break;}//�ڽ��� ū������ ���� �ʴٸ� ��
					
				}else{ //(list[p*2] < list[p*2+1])
					if((p*2 +1<= point) && list[p] < list[p*2+1]) { //�ٸ� ������ �ڽİ��� ���Ѵ�.
						swap(p,p*2+1);
						p = p*2+1;
					}else {break;}
				}
				
			}
			
		}

		public void check(int p) {
			while(p > 1 && list[p] > list[p/2]) {
				//System.out.println("p != 1");

				swap(p,p/2); //�ڽ��� ���� ��ũ�ٸ� ���� �ٲ۴�.
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
