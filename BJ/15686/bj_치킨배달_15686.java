package algo.hw;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_치킨배달_15686 {
	// 1부터 시작한다
	//1 집, 2치킨
	//도시의 치킨거리가 최소가되도록
	//M개를 구했을때, 최솟값은?
	
	//각집에서 최소거리가 되도록 최소 치킨집만을 남긴다.
	//부분집합
	static int arr[][];
	static int count_home;
	static int count_chi;
	static int combi[];
	static int [][] home ;
	static int [][] chicken;
	static int res = Integer.MAX_VALUE;
	static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a= Integer.parseInt(st.nextToken());
				arr[i][j] =a;
				if(a == 1) {
					count_home++;
				}else if(a==2) {
					count_chi++;
				}
			}
		}
		home = new int[count_home][2];
		chicken = new int[count_chi][2];
		combi = new int [M]; //치킨집 조합을 저장, 집의 수만큼 선별
		
		int h=0; 
		int c=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int a = arr[i][j] ;
				if(a == 1) {
					home[h][0] = i;
					home[h][1] = j;
					h++;
				}else if(a==2) {
					chicken[c][0] = i;
					chicken[c][1] = j;
					c++;
				}
			}
		}
		//입력
		comb(0,0);
		System.out.println(res);
	}
	//조합
	//count_chi
	static void comb(int index,int start) {
	
		if(index == M ) { //치킨집은 최소가 되어야한다.
			res =Math.min(res, check());
			return;
		}
		for(int i=start;i<count_chi;i++) {
			combi[index] =i;
			comb(index+1,i+1);
		}
	}
	//home
	//chicken
	static int check() { //각 조합에서 도시의 치킨거리를 꼐산한다.
		//System.out.println(Arrays.toString(combi));
		int sum=0;
		//
		for(int h=0;h<count_home;h++) {
			int dis = 0;
			int m=Integer.MAX_VALUE;
			for(int c=0;c<M;c++) {//combi[c]
				dis = Math.abs(home[h][0]-chicken[combi[c]][0]) +Math.abs(home[h][1]-chicken[combi[c]][1]);
				m = Math.min(m, dis); //각집의 최소 거리를 구한다.
			}
			sum+=m;
		}
		return sum;
	}
}