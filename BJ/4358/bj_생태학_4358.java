package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj_ปýลยวะ_4358 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String,Integer> map = new HashMap<>();
		
		String str = br.readLine();
		int count=0;
		while(str != null) {
			count++;
			if(map.get(str) != null) {
				map.put(str,map.get(str) + 1);
			}else {
				map.put(str, 1);
			}

			str = br.readLine();
		}
		Object list[] = map.keySet().toArray();
		Arrays.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Object name :list) {
			int n = map.get(name);
			sb.append(name).append(" ").append(String.format("%.4f",(float)n*100/(float)count)).append("\n");
		}

		
		System.out.println(sb);
	}

}
