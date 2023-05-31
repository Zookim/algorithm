package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj_¿Ã¥Ÿºÿ_1620 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<>();
		StringBuilder sb =  new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			String num = String.valueOf(i);
			map.put(str,num);
			map.put(num,str);
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			sb.append(map.get(str)).append("\n");
		}
		System.out.println(sb);
	}

}
