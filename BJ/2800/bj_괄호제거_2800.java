package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class bj_괄호제거_2800 {

	static boolean selected[];
	static char c[];
	static StringBuilder sb = new StringBuilder();
	static List<int[]> pair;
	
	static int N;
	static List<String> res = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		Stack<Integer> stack = new Stack<>();
		pair = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = br.readLine().toCharArray();
		
		//1. 쌍 찾기
		for(int i=0;i<c.length;i++) {
			char now = c[i];
			
			if(now == '(') {
				stack.push(i);
			}else if(now == ')') {
				pair.add(new int[] {stack.pop(),i});
			}
			
			
			
		}
		Collections.sort(pair ,(p1,p2) -> p1[0] - p2[0]); //시작위치를 기준으로 오름차순 정렬
		

		N = pair.size();
		
		selected = new boolean[N];
		
		
		dfs(0);
		
		Set<String> set = new HashSet<String>(res);
		res = new ArrayList<String>(set);
		Collections.sort(res);
		for(int i=1;i<res.size();i++) {
			//res.get(i).replaceAll(" ", "");
			sb.append(res.get(i)).append("\n");
		}
		System.out.println(sb);
		

	}
	
	static void dfs(int index) {

		if(index == N) {
			for(int i=0;i<N;i++) {
				if(!selected[i]) {
					c[pair.get(i)[0]]=' ';
					c[pair.get(i)[1]]=' ';
				}
			}
			String str = new String(c);
			res.add(str.replaceAll(" ", ""));
			
			for(int i=0;i<N;i++) {
				if(!selected[i]) {
					c[pair.get(i)[0]]='(';
					c[pair.get(i)[1]]=')';
				}
			}
			
			return;

		}
		
	
		selected[index] = true;
		dfs(index+1);
		selected[index] = false;
		dfs(index+1);

		
		
	}
	
	
}

