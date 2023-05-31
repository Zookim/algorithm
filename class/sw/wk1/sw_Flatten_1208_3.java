package sw.wk1;
// 강의 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
//Sanner 이용 :  0.17341s
// 
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw_Flatten_1208_3 {
	static int[] floor;
	static int dump,minidx,maxidx;
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t =1; t<=10;t++) {
			
			dump  = Integer.parseInt(b.readLine());
			floor = new int[100];
			
			StringTokenizer st = new StringTokenizer(b.readLine());
			for(int i=0;i<100;i++) {
				floor[i] = Integer.parseInt(st.nextToken());
			}
			// 반복적으로 dump만큼
			for(int i=0;i< dump;i++) {
				
				//최소, 최대 높이를 가지는 minidx, maxidx를 계산
				reset();
				//마지막 단계의 여부 확인 - 마지막이면 break 아니면 평탄화 작업 수행 maxIdx 하나 줄이고 minidx하나 늘리고
				int gap = floor[maxidx] - floor[minidx];
				if(gap ==0 || gap ==1) break;
				
				floor[maxidx]--;
				floor[minidx]++;
				
				
			}
			reset();
			
			int res = floor[maxidx] - floor[minidx];
			System.out.println("#" + t +" "+ res);
		}

	}
	
	// floor 배열의 최대 최소 계산
	static void reset() {
		for(int i=0;i<100;i++) {
			//min
			if(floor[i] < floor[minidx]) minidx = i;
			if(floor[i] > floor[maxidx]) maxidx = i;
			
		}
		
		
	}


}
