package basic.wk1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 스택꺼낼때 
//		//add == push
//		Stack<Integer> stack =new Stack<>();
//		stack.push(3);
//		stack.push(7);
//		stack.push(2);
//		stack.push(5);
//		
//		while(! stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
//		System.out.println();
//		
//		
//		//add == addLast
//		//push == addfirst
//		ArrayDeque<Integer> ad =new ArrayDeque<>(); //빠르다 양 옆으로만 넣을 수 있어서
//		//synchronized 가 없어서
//		ad.push(3);
//		ad.push(7);
//		ad.push(2);
//		ad.push(5);
//		
//		while(! ad.isEmpty()) {
//			System.out.println(ad.removeLast());
//		}
//		
//		System.out.println();
		
		Deque<Integer> stack = new ArrayDeque<>();
		// push - pop : 예상할수 있는 결과
		stack.push(3);
		stack.push(7);
		stack.push(2);
		stack.push(5);
		
		while(! stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println();
		
		
		
		
		
		
		Queue<Integer> queue =new ArrayDeque<>();
		queue.add(3);
		queue.add(7);
		queue.add(2);
		queue.add(5);
		
		while(! queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		

	}
	
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

}
