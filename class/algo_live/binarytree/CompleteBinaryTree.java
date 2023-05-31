package algo_live.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//완전 이진 트리 : 1차원 배열 구현
public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	public CompleteBinaryTree(int size){
		SIZE = size;
		nodes = new Object[size+1]; //제너릭으로 배열은 못만든다.
	}
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if(isFull()) return;
		
		nodes[++lastIndex] = e;
		
	}
	public void bfs() {
		//큐에는 탐색노드의 번호만 저장한다.
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // 루트 노드뷰터 출발

		int current =0;
		while(! queue.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
			current = queue.poll();
			System.out.println(nodes[current]);

			// 현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게한다.
			//완전이진트리 : 자식이 최대 2

			//왼쪽자식
			if(current * 2 <= lastIndex)queue.offer(current*2); //실제로 저장된 크기내에 있는지확인
			if((current*2+1 )<=lastIndex) queue.offer(current*2+1);	
		}

	}
	public void bfs2() {
		//큐에는 탐색노드의 번호만 저장한다.
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // 루트 노드뷰터 출발

		int current =0, size,level=0;
		while(! queue.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
			
			size = queue.size();
			System.out.print("level "+level+ ":");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current]+"\t");

				// 현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게한다.
				//완전이진트리 : 자식이 최대 2

				//왼쪽자식
				if(current * 2 <= lastIndex)queue.offer(current*2); //실제로 저장된 크기내에 있는지확인
				if((current*2+1 )<=lastIndex) queue.offer(current*2+1);	
			}
			level++; //  너비를 증가시킨다.
			System.out.println();
			
		}

	}
	public void dfsPre() { //전위 순회
		Stack<Integer> s = new Stack<>();
		s.push(1);
		
		int current=0;
		while(!s.isEmpty()) {
		
			current  = s.pop();
			System.out.print(nodes[current]+" ");
			
			if(current*2+1<=lastIndex) s.push(current*2+1); // 순회 방법에 따라서 push 순서가 달라진다.
			if(current*2<=lastIndex) s.push(current*2);
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		int size = 9;
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<Character>(size);

		for(int i=0;i < size;++i) {
			tree.add((char)(65+i));
		}
		//tree.bfs();
		//tree.bfs2();
		tree.dfsByPreOrder();
		tree.dfsByInOrder();
		tree.dfsByPostOrder();
		
		tree.dfsPre();

	}
	
	
	
	
	
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	public void dfsByPreOrder(int current) {
		//왼쪽
		System.out.print(nodes[current]+" ");
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
		
	}
	public void dfsByInOrder() {
		System.out.println("dfsByInOrder : ");
		dfsByInOrder(1);
		System.out.println();
	}
	public void dfsByInOrder(int current) {
		//왼쪽
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
		
	}
	public void dfsByPostOrder() {
		System.out.println("dfsByPostOrder : ");
		dfsByPostOrder(1);
		System.out.println();
	}
	public void dfsByPostOrder(int current) { /////////얘
		//왼쪽
		if(current*2<=lastIndex) dfsByPostOrder(current*2);
		
		if(current*2+1<=lastIndex) dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
		
	}



}
