package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_Contact_1238 {
	//2월 28일 폴더에 제출
	
	//가장나중에 연락받는 사람중 번호가 가장큰사람
	//서로소 집합, 인접리스트,단방향, 맨마지막 중 번호가 가장 큰사람 -> 큐
	static boolean visit[];
	static List<List<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case =1;test_case<=10;test_case++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			visit = new boolean[101]; 
			
			list= new ArrayList<>();
			
			for(int i=0;i<101;i++) {
				list.add(new ArrayList<Integer>());
			}
			
			st =  new StringTokenizer(br.readLine());
			for(int i=0;i<(dataLen/2);i++) {
				
				int go = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				list.get(go).add(end);
				
			}//인접리스트
			
			bfs(start);
			

			System.out.println("#"+test_case+" " +Big);
		}
		
		//
		

	}
	static int Big=0;
	static void bfs(int start) {
		
		Queue<Integer> que = new ArrayDeque<>();
		
		que.offer(start);
		que.offer(-1);
		visit[start] =true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now ==-1) {
				 //층이 다르면 초기화한다.
				if(que.isEmpty()){ break;}
				now = que.poll();
				que.offer(-1);
				Big=0;
				System.out.println();
			}
			visit[now] = true;
			Big = Big > now ? Big:now;//마지막층에서 가장 큰값을 저장
			List<Integer> nowlist = list.get(now);
			
			
			
			for(int a: nowlist) {
				
				if(visit[a]) continue;
				visit[a] =true;
				que.offer(a);
				
				System.out.print(a+" ");
				
			}
			//System.out.println();
	
		}
	}

}
