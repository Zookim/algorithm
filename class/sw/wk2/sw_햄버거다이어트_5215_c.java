package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_�ܹ��Ŵ��̾�Ʈ_5215_c {

	//Į�θ������� ����, ��ȣ�ϴ� ����
	//2���� �̻��� Ǯ��
	static Item arr[];
	static int N,L,T;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //����Ǽ�
			L = Integer.parseInt(st.nextToken()); //Į�θ�
			
			arr = new Item[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); //��

			}
			//�κ� ���� 
			subSet(0,0);
			System.out.println("#"+test+" "+max);

		}
	} //���, for
	static void subSet(int index,int mask) { 
		if(index == N) {
			//System.out.println(mask);//mask�� �ٽ�
			int cal=0;
			int point =0;
			
			for(int i=0;i<N;i++) {
				if((mask &(1<<i)) ==0) continue; //���õ��� ������ ����
				cal += arr[i].c;
				point += arr[i].p;
			}
			if(cal <=L)max = Math.max(max,point);
			return;
		}
		subSet(index+1,(mask | (1<<index)));
		subSet(index+1,mask);
	}
		
	
	static class Item{
		int p,c;

		public Item(int p, int c) {
			super();
			this.p = p;
			this.c = c;
		}
		
		
	}
	
}


