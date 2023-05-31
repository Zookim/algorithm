package algo_live.stack;

public class LinkedListstack<E> implements Istack<E> {

	private Node<E> top;
	@Override
	
	public void push(E e) {
		//top으로 삽입
		top = new Node<E>(e,top); // 받아온값을 노드에 저장하고 top이 이를 받아온다.
		
	}

	@Override
	public E pop() {
		if(isEmpty()) return null;
		
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) return null;
		
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int count =0;
		for(Node<E> temp = top; temp != null;temp = temp.link) {
			count++;
			
		}
		return count;
	}
	

}
