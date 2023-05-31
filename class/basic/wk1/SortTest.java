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
			System.out.println(node); //넣어준 순서 그대로
		}
		
		System.out.println();
		
		
		
		// #1
		//Collections.sort(list);
		//#2-1
		//sort를 호출하면서 Comparable인터페이스를 구현한 객체를 전달
		//객체를 익영 inner class형태로 전달
		//1의 경우와 2의경우를 동시에 사용하면 2의 정렬이 더 우선된다.
		//정렬을 계속해서 이용하는 경우에 1의 경우가 2의 경우보다 유리하다
		
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
			System.out.println(node); //넣어준 순서 그대로
		}

	}
	
//	//#2Comparable을 구현 x
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
	
	
	
	
	
	
	
	
	
	//#1 Comparable을 구현하는 방법
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
		public int compareTo(Node o) { //애가 있어야 Collections의 sort를 사용할 수 있다., 정렬 기준 선정
			// TODO Auto-generated method stub
			//return this.y - o.y; //y를 오름차순 정렬
			//return o.y - this.y; //y를 내림차순 정렬
			// 삼항연산자 중첩
			//return   o.y != this.y ?o.y - this.y :  ( o.x != this.x?o.x - this.x: o.c - this.c); //y가 같을때 x를 기준으로 정렬
			return o.x - this.x;
		}
	}

}
