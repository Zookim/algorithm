package basic.wk1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// synchronized : �����忡�� �����ϰ� �����ϵ��� ��
		Stack<Integer> stack =new Stack<>();
		stack.add(3); //synchronized  �ִ�
		stack.add(7);
		stack.add(2);
		stack.add(5);
		
		while(! stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println();
		
		ArrayDeque<Integer> ad =new ArrayDeque<>();
		ad.add(3); //synchronized  ����
		ad.add(7);
		ad.add(2);
		ad.add(5);
		
		while(! ad.isEmpty()) {
			System.out.println(ad.removeLast());
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

}
