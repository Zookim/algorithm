package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class bj_이중우선순위큐_7662 {

	public static void main(String[] args) throws Exception{
		//TreeMap은 red-black Tree로 이루어져있다.
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase =1;testcase<=T;testcase++) {
			
			TreeMap<Integer,Integer> treemap = new TreeMap<>();

			
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String m = st.nextToken();
				int n= Integer.parseInt(st.nextToken());//키값이 되어 정렬되도록한다.

				if(m.equals("I")) {//중복되는 값이 존재할때
					if(treemap.get(n) != null) {
						treemap.put(n,treemap.get(n)+1);
					}else {
						treemap.put(n, 1);
					}
				}else {
					if(treemap.isEmpty()) continue;
					if(n == -1) { //최솟값제거
						int key = treemap.firstKey();
						if(treemap.get(key) == 1 ) {
							treemap.remove(key);
						}else {
							treemap.put(key,treemap.get(key)-1);
						}
						
					}else { //최대 값 제거
						int key = treemap.lastKey();
						if(treemap.get(key) == 1 ) {
							treemap.remove(key);
						}else {
							treemap.put(key,treemap.get(key)-1);
						}
					}
				}
				System.out.println(treemap);

			}
			
			if(treemap.isEmpty()) {
				sb.append("EMPTY\n");
			}else {
				sb.append(treemap.lastKey()).append(" ").append(treemap.firstKey()).append("\n");	
			}
			
			
		}
		System.out.println(sb);
		
		
		

	}

}
