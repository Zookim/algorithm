package basic.wk1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class StackQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ���ò����� 
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
//		ArrayDeque<Integer> ad =new ArrayDeque<>(); //������ �� �����θ� ���� �� �־
//		//synchronized �� ���
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
		// push - pop : �����Ҽ� �ִ� ���
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
