package algo_live.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//���� ���� Ʈ�� : 1���� �迭 ����
public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	public CompleteBinaryTree(int size){
		SIZE = size;
		nodes = new Object[size+1]; //���ʸ����� �迭�� �������.
	}
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e) {
		if(isFull()) return;
		
		nodes[++lastIndex] = e;
		
	}
	public void bfs() {
		//ť���� Ž������� ��ȣ�� �����Ѵ�.
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // ��Ʈ ������ ���

		int current =0;
		while(! queue.isEmpty()) { //ť�� ����ϰ� �ִ� ������� ��� ó��
			current = queue.poll();
			System.out.println(nodes[current]);

			// ���� ����� �ڽĳ����� ť�� �־� ������ ��ٸ����Ѵ�.
			//��������Ʈ�� : �ڽ��� �ִ� 2

			//�����ڽ�
			if(current * 2 <= lastIndex)queue.offer(current*2); //������ ����� ũ�⳻�� �ִ���Ȯ��
			if((current*2+1 )<=lastIndex) queue.offer(current*2+1);	
		}

	}
	public void bfs2() {
		//ť���� Ž������� ��ȣ�� �����Ѵ�.
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // ��Ʈ ������ ���

		int current =0, size,level=0;
		while(! queue.isEmpty()) { //ť�� ����ϰ� �ִ� ������� ��� ó��
			
			size = queue.size();
			System.out.print("level "+level+ ":");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current]+"\t");

				// ���� ����� �ڽĳ����� ť�� �־� ������ ��ٸ����Ѵ�.
				//��������Ʈ�� : �ڽ��� �ִ� 2

				//�����ڽ�
				if(current * 2 <= lastIndex)queue.offer(current*2); //������ ����� ũ�⳻�� �ִ���Ȯ��
				if((current*2+1 )<=lastIndex) queue.offer(current*2+1);	
			}
			level++; //  �ʺ� ������Ų��.
			System.out.println();
			
		}

	}
	public void dfsPre() { //���� ��ȸ
		Stack<Integer> s = new Stack<>();
		s.push(1);
		
		int current=0;
		while(!s.isEmpty()) {
		
			current  = s.pop();
			System.out.print(nodes[current]+" ");
			
			if(current*2+1<=lastIndex) s.push(current*2+1); // ��ȸ ����� ���� push ������ �޶�����.
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
		//����
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
		//����
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
		
	}
	public void dfsByPostOrder() {
		System.out.println("dfsByPostOrder : ");
		dfsByPostOrder(1);
		System.out.println();
	}
	public void dfsByPostOrder(int current) { /////////��
		//����
		if(current*2<=lastIndex) dfsByPostOrder(current*2);
		
		if(current*2+1<=lastIndex) dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
		
	}



}
