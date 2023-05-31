package my.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_러시아국기같은깃발_4613 {

	// w,b,r ,0,1,2
	// 위에서 부터 각 줄마다 색의 수를 구하고, 
	// 가장 첫줄과 마지막줄은 변동되지 않는다.
	//둘째줄부터 
	static int N,M;

	static int map [][];
	static int ans;
	
	static int select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int test=1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][3];
			select = new int[N];//어떤 색이 선택되었는지 확인
			
			
			
			char n='a';
			int a=0;
			int w=0;
			int b=0;
			int r=0;

			bcount=0;
			cur=0;
			min = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				char arr[] =  br.readLine().toCharArray();
				for(int j=0;j<M;j++) {
					n =   arr[j];
					a = (n =='W') ? ++w :((n =='B')? ++b : ++r) ; // 각색의 수를 센다/
					

				}
				map[i][0] = b+r;
				map[i][1] = w+r;
				map[i][2] = w+b;
				w=0;
				b=0;
				r=0;
			}
			
//			for(int aa[]: map) {
//				System.out.println(Arrays.toString(aa));
//			}
//			
			
			//첫줄과 마지막줄
			ans=0;
			ans = map[0][0] +map[N-1][2]; //w가 아닌수, R이 아닌수
			select[0]=0;
			select[N-1]=2;
			
			//System.out.println(ans);
			comb(0,1); //모든 색, 시작위치
			ans+=min; 
			System.out.println(ans);
			
			
			//양끝이 정해진 중복조합
			//
		}


	}
	static int bcount=0;
	static int cur=0;
	static int min = Integer.MAX_VALUE;
	
	static void comb(int start,int index) {
		
		if(index==N-1) {//N-1번째도 고려하지 않는다.
			System.out.println("asd"+Arrays.toString(select));
			if(bcount>=1 && cur<min) {
				System.out.println("asd"+Arrays.toString(select));
				//System.out.println(cur);
				min = cur;

			}
	
			return ;
		}

		for(int i=start;i<3;i++) {
			if(i==1) bcount++;
			System.out.println("index "+index+" i "+i);
			cur+= map[index][i]; //각 줄에서 바꾸아야하는 색
			select[index]=i;
			comb(i+1,index+1);
			
			if(i==1) bcount--;
			cur-= map[index][i];
		}
	}

}
