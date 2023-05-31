package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_트리순회_1991 {

	static char tree[] = new char[32];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		tree[1] = 'A';
		int [] arr = new int[26];
		arr[0] =1;
		for(int i=1;i <= N;i++) {
			st = new StringTokenizer(br.readLine());
			char r = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			int index = arr[(int)r - 'A'];
			if(left != '.') {arr[(int)left - 'A'] = index*2;}
			if(right != '.') {arr[(int)right - 'A'] = index*2+1;}
			tree[index*2] = left;
			tree[index*2+1] = right;

		}
		
		preorder(1);
		sb.append("\n");
		
		inorder(1);
		sb.append("\n");
		
		postorder(1);
		sb.append("\n");
		//System.out.println(Arrays.toString(tree));
		System.out.println((int)'Z' - (int)'A');
		System.out.println(sb);

	}
	static void preorder(int index) {
		if(tree[index] == '.') return;
		sb.append(tree[index]);
		preorder(index*2);
		preorder(index*2 +1);


	}
	static void inorder(int index) {
		if(tree[index] == '.') return;

		
		inorder(index*2);
		sb.append(tree[index]);
		inorder(index*2 +1);


	}
	static void postorder(int index) {
		if(tree[index] == '.') return;
		postorder(index*2);
		postorder(index*2 +1);
		sb.append(tree[index]);

	}

}
