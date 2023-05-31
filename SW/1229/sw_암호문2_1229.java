package my.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_암호문2_1229 {

	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int test_case = 1;test_case <= 1;test_case++) {
			
			int len_ori = Integer.parseInt(b.readLine());
			Node head = new Node();
			Node pointer = head;
			st = new StringTokenizer(b.readLine());
			for(int i=0;i<len_ori;i++) {
				pointer = LinkedList.addNode(Integer.parseInt(st.nextToken()),pointer);
				//System.out.println(pointer.getData());
			}
			
			// 입력 완료
			
			int len = Integer.parseInt(b.readLine());
			st = new StringTokenizer(b.readLine());
			
			for(int i=0;i<len;i++) {
				String str = st.nextToken();
				if(str.equals("I")) {
					insert(head,st);
					//System.out.println(st.nextToken());
				}
				else if(str.equals("D")) {
					delete(head,st);
				}
				
			}
			
			pointer = head;
			pointer = pointer.getLink();
			int index =1;
			System.out.print("#"+test_case+" ");
			while(index <= 10) {
				System.out.print(pointer.getData()+" ");
				pointer = pointer.getLink();
				index++;
			}
			System.out.println();

		}
	}
	
	
	
	static class LinkedList{
		static Node addNode(int data, Node pointer){
			Node now = new Node(data);
			pointer.setLink(now);
			return now;
			
			
		}
		static Node insertNode(Node pointer, int data) {
			Node node = new Node(data);
			node.setLink(pointer.getLink());
			pointer.setLink(node);
			return node;
		}
		static Node deleteNode(Node pointer) { //뒤의 것 제거
			//
			
			Node next_loc = pointer.getLink().getLink();
			pointer.setLink(next_loc);
			return next_loc;
			//
			
		}


	}
	static void delete(Node head,StringTokenizer st) {

		//System.out.println("delete");
		int loc = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		//System.out.println(loc);
		//System.out.println(num);

		for(int i=0;i<loc;i++) {
			head = head.getLink();
		} // head 다음 위치 부터 삭제

		for(int i=0;i<num;i++) {
			head = LinkedList.deleteNode(head);
		}

	}
	static void insert(Node head,StringTokenizer st) {
		
		int loc = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		//System.out.println(loc);
		//System.out.println(num);
		
		for(int i=0;i<loc;i++) {
			head = head.getLink();
		} // head 다음 위치 부터 삽입
		
		for(int i=0;i<num;i++) {
			head = LinkedList.insertNode(head,Integer.parseInt(st.nextToken()));
		}
		
	}
	
	

}
//class Node{
//	int data;
//	Node link = null;
//	Node(){}
//	Node(int data){
//		this.data = data;
//	}
//	void setLink(Node pointer) {
//		this.link = pointer;
//	}
//	Node getLink() {
//		return this.link;
//	}
//	int getData() {
//		return this.data;
//	}
//
//	
//}

