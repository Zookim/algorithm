package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class jo_≥√¿Â∞Ì_1828 {
	
	private static class Cooler implements Comparable<Cooler>{
		
		int low;
		int high;
		public Cooler(int low, int hight) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Cooler o) {
			// TODO Auto-generated method stub
			return this.low != o.low? this.low - o.low:this.high - o.high ;
		}
	
	}


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
		Cooler[] arr = new Cooler[T];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Cooler(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

		}
		
		Arrays.sort(arr);
		
		List<Cooler> res = new ArrayList<Cooler>();
		res.add(arr[0]); 
		
		for(int i=1;i<T;i++) {
			if(res.get(res.size()-1).low <= arr[i].high) {
				res.add(arr[i]);
			}
		}
		System.out.println(res.size());
//		for(Cooler c: res) {
//			System.out.println(c);
//		}

	}

}
