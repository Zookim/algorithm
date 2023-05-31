package hw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;



public class BJ_Ä«µå2_2164 {

	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1;i<=num;i++) {
			q.add(i);
		}
		int i=1;
		int n=0;
		while(true) {
			if(i%2 != 0) {n=q.poll();}
			else {n = q.poll(); q.add(n);}
			i++;
			if(q.isEmpty()) {break;}
			//System.out.println(q);
		}
		System.out.println(n);

	}

}
