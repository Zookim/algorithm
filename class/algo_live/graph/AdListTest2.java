package algo_live.graph;

import java.util.ArrayList;
import java.util.Scanner;



public class AdListTest2 {
	
	
	static ArrayList<Integer>[] adList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		adList = new ArrayList[v]; //head가 null인 상태
		for(int i=0; i<v;i++) { //이렇게 미리 넣어 주어야 2차원 형태로 구성 할 수 있다.
			adList[i] = new ArrayList<Integer>();
		}
		
		
		int from, to;
		for (int i = 0; i < e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adList[from].add(to);
			adList[to].add(from);
			//방향그래프시 , 한쪽에만 적어준다
			//adList[from] = new Node(to,adList[from]);
		
		}
		print();
	}
	static void print() {
		for(ArrayList<Integer> a: adList) {
			System.out.println(a);
		}
	}

}
