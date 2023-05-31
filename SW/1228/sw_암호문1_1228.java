package my.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_암호문1_1228 {

	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int test_case = 1;test_case <= 10;test_case++) {
			
			int len_ori = Integer.parseInt(b.readLine());
			
			st = new StringTokenizer(b.readLine());
			
			Node head = new Node(); // 없애야한다.
			Node pointer = head;
			for(int i = 0 ; i< len_ori;i++) {
				pointer = LinkedList.addNode(Integer.parseInt(st.nextToken()),pointer);
				//System.out.println(pointer.getdata());
			}
			
			//
			
			int len_com = Integer.parseInt(b.readLine());
			st = new StringTokenizer(b.readLine());
			
			for(int i = 0 ; i< len_com;i++) {
				st.nextToken(); //명령문
				int num = Integer.parseInt(st.nextToken());
				pointer = head;
				for(int j=0;j<num;j++) { // 포인터 찾기
					pointer = LinkedList.next(pointer);
				}
				int len =  Integer.parseInt(st.nextToken());
				
				
				for(int j = 0;j<len;j++) {
					pointer = LinkedList.insertNode(Integer.parseInt(st.nextToken()),pointer);
	
				}
				//System.out.println(pointer.getdata());
			}
			
			pointer = head;
			pointer = LinkedList.next(pointer);
			int index =0;
			System.out.print("#"+test_case+" ");
			while(index < 10) {
				System.out.print(pointer.getdata() +" ");
				pointer = LinkedList.next(pointer);
				index++;
			}
			System.out.println();

			
		}
		

	}
	static class LinkedList{

		static Node addNode(int data,Node p) {
			
			Node node = new Node(data);
			p.Link(node);
			return node;
		}
		static Node next(Node p) {return p.getLink();}
		static Node insertNode(int data, Node p) {
			Node node = new Node(data);
			Node tmp = p.getLink();
			p.Link(node);
			node.Link(tmp);
			return node;
		}

	}
	

}
class Node1{
	int data;
	Node link;
	
	Node(){}
	Node(int data){
		this.data = data;
	}

	void Link(Node link) {
		this.link = link;
	}
	int getdata() {
		return this.data;
	}
	Node getLink() {
		return this.link;
	}
	
}

