package algo.wk11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_�����̺��̱�_17136 {
//��� ���µ� �ʿ��� �ּ� ������ �� 
	//�� �����̴� 5����
	// �Ź� 100���� ĭ�� ���鼭 Ȯ���Ѵ�.
	static int map[][] = new int [10][10];
	static int paper[] = {0,5,5,5,5,5};
	static int mins = 25;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//printmap();
		// 1. �� ��ü�� ���� 1�� ���� �ִ��� Ȯ���Ѵ�.
		// 2. 1�� ã���� ���簢���� ���ʴ�� ���Ѵ�. -> �ϳ� ã�Ҵ� -> ���̸� ���δ�.-> ���� ������ �̵� ->1�� ã�´�....-> ���̸� ����. ���� ũ��� ���Ѵ�.
		// 3. ���簢���� ���� ����.
		// 4.
		dfs(0,0,0);
		
		if (mins == 25) { //������ ���� ���Ѱ��
			System.out.println(-1);
		}else {
			System.out.println(mins);
		}
		

	}
	static void dfs(int r, int c,int num) {
		//System.out.println("r "+r+" c "+ c+" mins "+mins);
		//printmap();
		if(num > mins) {
			return;
		}
		//1�� ã�´�.
		while(true) {
			
			if(c>=10) {r++;c=0;}
			if(r==10) {// �����Ѵ�.
				mins = num;
				return;
				}
			else {
				if(map[r][c] == 1) break;
			}
			c++;
		}
		
		
		for(int i=5;i>0;i--) {
			if(paper[i] == 0) continue;
			
			if(r+i>10 || c+i>10) continue;
		
			if(check(r,c,i)) { //���ϼ� �ִ�.
				paper[i]--;
				attach(r,c,i);
				dfs(r,c+i,num+1);
				paper[i]++;
				detach(r,c,i);
				
			}
		}
		
		return;// ���ݱ����� �������� ������ ���ϴ� ���
		
	}
	static void attach(int r, int c, int paper) {
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				map[i][j] = 0;
			}
		}
	}
	
	static void detach(int r, int c, int paper) {
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				map[i][j] = 1;
			}
		}
	}
	
	static boolean check(int r, int c, int paper) {
		
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void printmap() {
		System.out.println(Arrays.toString(paper));

		for(int i[] : map) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

}
