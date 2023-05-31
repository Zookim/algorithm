package basic.wk1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortPriorityQueueTest {
//Class 
	public static void main(String[] args) {
		//1
		//PriorityQueue<Node> pqueue = new PriorityQueue<>();
		
		//2 ... 왜됭ㄹ?
		PriorityQueue<Node> pqueue = new PriorityQueue<>((n1,n2)->n1.x-n2.x);
		pqueue.add(new Node(7,3,5));
		pqueue.add(new Node(4,6,8));
		pqueue.add(new Node(3,9,3));
		pqueue.add(new Node(2,4,6));
		
		for (Node node : pqueue) {
			System.out.println(node); //넣어준 순서 그대로 나온다, 꼭 정렬된 대로 나오지 않을수도 있다.
		}
		System.out.println();
		//1
		while(!pqueue.isEmpty()) { // poll()을 통해 꺼낼때 정렬되어서 나온다.
		System.out.println(pqueue.poll());
		}
	}

	//2
	static class Node{
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
		
		
	}
	
//	//1
//	static class Node implements Comparable<Node> {
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
//		@Override
//		public int compareTo(Node o) {
//			// TODO Auto-generated method stub
//			return this.x - o.x;
//		}
//		
//	}
	
	
	
//	
//	// #1
//	//Collections.sort(list);
//	//#2-1

////	Collections.sort(list, new Comparator<Node>() {
////
////		@Override
////		public int compare(Node o1,Node o2) {
////			// TODO Auto-generated method stub
////			return o1.y - o2.y;
////		}
////		
////	});
//	//#2-2
//	
//	Collections.sort(list,(o1,o2) -> o1.y-o2.y ); 
//	
//	for (Node node : list) {
//		System.out.println(node); //넣어준 순서 그대로
//	}

}
	
	



