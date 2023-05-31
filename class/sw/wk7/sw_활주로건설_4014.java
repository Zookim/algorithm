package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw_활주로건설_4014 {

	//경사로는 길이가 X 이고, 높이는 1 이다.
	//경사로를 지형 밖까지 설치해야 되기 때문에 활주로를 설치할 수 없다.
	// 행이나 , 열 전체가 이어져야 활주로 하나가 완성된다.
	static int N,X;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//입력
			int row=0;
			//행을 돌며 조건을 만족하는 활주로의 수를 구한다.
			row = findRow();
			//System.out.println("row " + row);
			//열을 돌며 ..
			int col=0;
			col = findCol();
			
			//System.out.println(" col "+col);
			System.out.println("#"+test_case+" " +(row+col));
			
			
		}
		//테스트케이스

	}
	static int findCol() {
		int res=0;
		
		for (int i = 0; i < N; i++) {
			int count=1;
			List<int[]> list = new ArrayList<>();
			for (int j = 1; j < N; j++) {
				if(map[j-1][i] != map[j][i]) {
					list.add(new int[]{map[j-1][i],count});
					count =1;
				}else {
					count++;
				}
			}
			list.add(new int[]{map[N-1][i],count});
			

			boolean ok = true;
			if(list.size() == 1)res++;
			else {
				//System.out.println("i "+i);
				//System.out.println(list.get(0)[0] + " "+list.get(0)[1]);
				for(int k=1;k<list.size();k++) {
					//System.out.println(list.get(k)[0] + " "+list.get(k)[1]);
					if(list.get(k-1)[0] - list.get(k)[0] == 1) { // 앞이 더 높다면
						if(list.get(k)[1] < X) {ok=false;break;} // 안된다.
						else {list.get(k)[1] -= X;}
					}else if(list.get(k-1)[0] - list.get(k)[0] == -1){ //뒤가 더 높다면 
						if(list.get(k-1)[1] < X) {ok=false;break;} // 안된다.
						else {list.get(k-1)[1] -= X;}
					}else {ok=false;}
				}

				
				if(ok) {
					//System.out.println("열 "+i);
					res++;
					}
			}
		}
		return res;
		
		
	}
	static int findRow() {
		int res=0;
		
		for (int i = 0; i < N; i++) {
			int count=1;
			List<int[]> list = new ArrayList<>();
			for (int j = 1; j < N; j++) {
				if(map[i][j-1] != map[i][j]) {
					list.add(new int[]{map[i][j-1],count});
					count =1;
				}else {
					count++;
				}
			}
			list.add(new int[]{map[i][N-1],count});
			
		
			boolean ok = true;
			if(list.size() == 1)res++;
			else {
				//System.out.println(list.get(0)[0] + " "+list.get(0)[1]);
				for(int k=1;k<list.size();k++) {
					//System.out.println(list.get(k)[0] + " "+list.get(k)[1]);
					if(list.get(k-1)[0] - list.get(k)[0]==1) { // 앞이 더 높다면
						if(list.get(k)[1] < X) {ok=false;break;} // 안된다.
						else {list.get(k)[1]-= X;}
					}else if(list.get(k-1)[0] - list.get(k)[0]==-1){ //뒤가 더 높다면 
						if(list.get(k-1)[1] < X) {ok=false;break;} // 안된다.
						else {list.get(k-1)[1]-=X;}

					}else {ok=false;}
				}

				//System.out.println();
				if(ok) {
					//System.out.println("행 "+i);
					res++;
					}
			}
		}
		return res;
	}
}
