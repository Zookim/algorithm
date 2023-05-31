package basic.wk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node> list = new ArrayList<>();
		list.add(new Node(7,3,5));
		list.add(new Node(4,6,8));
		list.add(new Node(3,4,3));
		list.add(new Node(2,4,6));
		
		for (Node node : list) {
			System.out.println(node); //�־��� ���� �״��
		}
		
		System.out.println();
		
		
		
		// #1
		//Collections.sort(list);
		//#2-1
		//sort�� ȣ���ϸ鼭 Comparable�������̽��� ������ ��ü�� ����
		//��ü�� �Ϳ� inner class���·� ����
		//1�� ���� 2�ǰ�츦 ���ÿ� ����ϸ� 2�� ������ �� �켱�ȴ�.
		//������ ����ؼ� �̿��ϴ� ��쿡 1�� ��찡 2�� ��캸�� �����ϴ�
		
//		Collections.sort(list, new Comparator<Node>() {
//
//			@Override
//			public int compare(Node o1,Node o2) {
//				// TODO Auto-generated method stub
//				return o1.y - o2.y;
//			}
//			
//		});
		//#2-2
		
		Collections.sort(list,(o1,o2) -> o1.y-o2.y ); 
		
		for (Node node : list) {
			System.out.println(node); //�־��� ���� �״��
		}

	}
	
//	//#2Comparable�� ���� x
//	static class Node{
//		int y,x,c;
//		Node(int y,int x,int c){
//		this.c = c;	
//		this.y = y;	
//		this.x = x;	
//		}
//		@Override
//		public String toString() {
//			return "Node [y=" + y + ", x=" + x + ", c=" + c + "]";
//		}
//		
//	}
	
	
	
	
	
	
	
	
	
	//#1 Comparable�� �����ϴ� ���
	static class Node implements Comparable<Node>{
		int y,x,c;
		Node(int y,int x,int c){
		this.c = c;	
		this.y = y;	
		this.x = x;	
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", c=" + c + "]";
		}
		@Override
		public int compareTo(Node o) { //�ְ� �־�� Collections�� sort�� ����� �� �ִ�., ���� ���� ����
			// TODO Auto-generated method stub
			//return this.y - o.y; //y�� �������� ����
			//return o.y - this.y; //y�� �������� ����
			// ���׿����� ��ø
			//return   o.y != this.y ?o.y - this.y :  ( o.x != this.x?o.x - this.x: o.c - this.c); //y�� ������ x�� �������� ����
			return o.x - this.x;
		}
	}

}
