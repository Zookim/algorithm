package algo.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_달팽이숫자_1954 {
	static int v=1;
	static int r =0;
	static int c=-1;
	static int num;
	static int [][] arr;
	public static void main(String[] args) throws Exception {
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(b.readLine());
		for(int i=1;i<=T;i++) {
			num = Integer.parseInt(b.readLine());
			arr = new int[num][num];
			
			r=0;
			c=-1;
			v=1;
			

			while(v <= num*num) {
				if(right()) break;
				if(down()) break;
				if(left())break;
				if(up())break;
				
				
			}
			System.out.println("# "+i);
			for(int a =0;a<num;a++){
				for(int j =0;j<num;j++){
					System.out.print(arr[a][j]+" ");
				}
				System.out.println();
			}



		}

	}
	static boolean right() { //처음 위치포함
		while(true) {
			c++;
			//System.out.println(c);
			if(c>=num || arr[r][c] != 0) {
				c--;
				return false;
			}else {
				arr[r][c] = v;
				
				v++;
				
			}
			
			if(v == num*num+1) {return true;}
		}
		
	}
	static boolean down() { //처음 위치포함
		while(true) {
			r++;
			if(r>=num || arr[r][c] != 0) {
				r--;
				return false;
			}else {
				arr[r][c] = v;
				v++;
			}
			if(v == num*num+1) {return true;}
		}
		
	}
	static boolean left() { //처음 위치포함
		while(true) {
			c--;
			if(c<0 || arr[r][c] != 0) {
				c++;
				return false;
			}else {
				arr[r][c] = v;
				v++;
			}
			if(v == num*num+1) {return true;}
		}
		
	}
	static boolean up() { //처음 위치포함
		while(true) {
			r--;
			if(r<0 || arr[r][c] != 0) {
				r++;
				
				return false;
			}else {
				arr[r][c] = v;
				v++;
			}
			if(v == num*num+1) {return true;}
		}
		
	}
	

}
