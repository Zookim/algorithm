package algo_live.graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdListTest {
	
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static Node[] adList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		adList = new Node [v]; //head가 null인 상태

		int from, to;
		for (int i = 0; i <e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adList[from] = new Node(to,adList[from]);
			adList[to] = new Node(from,adList[to]);
			//방향그래프시 , 한쪽에만 적어준다
			//adList[from] = new Node(to,adList[from]);
		
		}
		print();
	}
	static void print() {
		for(Node a: adList) {
			System.out.println(a);
		}
	}

}
