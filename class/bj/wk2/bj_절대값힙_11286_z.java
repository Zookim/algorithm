package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_���밪��_11286_z {

	static int [] arr;
	static int lastindex;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i=0;i<N;i++) {
			int data = Integer.parseInt(br.readLine());
			
			if(data == 0) {
				System.out.println(out()); // �������� �ִ� ���� ���ְ� �����Ѵ�.
				sort2(lastindex);
			}
			else {
				push(data); // �����͸� ���� �־��ְ�, �������Ѵ�.
				sort(lastindex-1);
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	// �������� ���밪 -> �������� ��
	static int out() {
		int res = arr[1];
		arr[1] =arr[lastindex];
		arr[lastindex]=0;
		
		return res;
	}

	static void sort2(int index) { // �Ʒ����� ����  ����

		if(index >= arr.length) return;

		int c [] = new int[2];
		int now = arr[index];
		 c[0] = arr[index*2];
		 c[1] = arr[index*2+1];
		int in=0;
		if(Math.abs(c[0]) >= Math.abs(c[1])) {
			if(Math.abs(c[0]) == Math.abs(c[1])) {
				if(c[0] > c[1]) {in=1;}
			}else {in=1;}
		}

		if(Math.abs(now) < Math.abs(c[in])) {
			
			int tmp = arr[index];
			arr[index] = arr[index*2+in];
			arr[index+in] = arr[index];
			index = (in ==1)?(index*2):(index*2+1);
			sort(index);
		}else if(Math.abs(now) == Math.abs(c[in])) {
			if(now <c[in]) {
				
				int tmp = arr[index];
				arr[index] = arr[index*2+in];
				arr[index+in] = arr[index];
				index = (in ==1)?(index*2):(index*2+1);
				sort(index);
			}

		}

	}

	static void push(int data) {
		arr[++lastindex] = data;
	}
	
	static void sort(int index) { // �Ʒ����� ����  ����
		System.out.println(lastindex);
		if(index ==1) return;
		
		int now = arr[index]; //-1 ??
		int parent = arr[index/2]; //1
		//System.out.println(now);
		//System.out.println(parent);
		if(Math.abs(now) < Math.abs(parent)) {
			arr[index] = parent;
			arr[index/2] = now;
		
			sort(index/2);
		}else if(Math.abs(now) == Math.abs(parent)) { //
			//System.out.println("sdf");
			if(now < parent) {
				//System.out.println("sdf");
				arr[index] = parent;
				arr[index/2] = now;
		
				sort(index/2);
			}
		}
	}
	

}
