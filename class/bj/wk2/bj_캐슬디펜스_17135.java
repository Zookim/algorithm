package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_ĳ�����潺_17135 {

	static int N,M,D,max;
	static int [] archer = new int[3];
	static List<Enemy> enemyCopy=new ArrayList<>();
	static List<Enemy> enemy=new ArrayList<>();
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>(
			(e1,e2)->e1.d == e2.d ? e1.x - e2.x:e1.d-e2.d);
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(n == 1) {enemyCopy.add(new Enemy(i,j));}
			}
		}
		
		comb(0,0);
		System.out.println(max);
		
		
		
		
	}
	static void check() {
		//���� ���� ���� ���
		//�ִ밪 Max�� ���
		
		//enemy�� �ʱ�ȭ
		//while : �� �ü����� 1�� ���� �� �ִٸ� ���δ�.
		// ��List�� ���� - ���� ���� ���� , ���� �Ʒ��� ��������.
		//������� �� �׾����� Ȯ�� break - �ƴϸ� while�� �ݺ�
		
		enemy.clear();
		for(Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y,e.x));
		}
		int dead =0;
		while(true) {
			
			for(int i=0;i<3;i++) { //���� ����� ���� ã������ PriorityQueue�� �̿�
				pqueue.clear();
				int ac = archer[i];
				int size = enemy.size();
				for(int j=0;j<size;j++) {
					Enemy e= enemy.get(j);
					e.d = Math.abs(ac - e.x) +  Math.abs(N - e.y);
					if(e.d <= D) pqueue.offer(e); // �����Ÿ� ���� ����
				}
				if(! pqueue.isEmpty()) pqueue.poll().dead = true; //����� �� ���ǥ��
			}
		
		//���� ���� ���� �����Ѵ�, ���� �Ʒ��� ������.
		for(int i=(enemy.size()-1);i>=0;i--) {
			Enemy e =enemy.get(i);
			if(e.dead) {
				enemy.remove(i);
				dead++;
			}else if(e.y ==N-1){
				enemy.remove(i);
			}else {
				e.y++;
			}
		}
		if(enemy.size() ==0) break;
		}
		max = Math.max(max, dead);
		
	}
	static void comb(int srcindex,int tgtindex) {
		if(tgtindex ==3) {
			check();
			return;
		}
		if(srcindex == M)return;
		
		archer[tgtindex] = srcindex;
		
		comb(srcindex+1,tgtindex+1); // ������ ����
		comb(srcindex+1,tgtindex); // ������ ���þ���
	}
	static class Enemy{
		int y,x,d;
		boolean dead;
		
		Enemy(int y,int x){
			this.y = y;
			this.x=x;
		}
	}

}
