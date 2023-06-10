package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class bj_���߿켱����ť_7662 {

	public static void main(String[] args) throws Exception{
		//TreeMap�� red-black Tree�� �̷�����ִ�.
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testcase =1;testcase<=T;testcase++) {
			
			TreeMap<Integer,Integer> treemap = new TreeMap<>();

			
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String m = st.nextToken();
				int n= Integer.parseInt(st.nextToken());//Ű���� �Ǿ� ���ĵǵ����Ѵ�.

				if(m.equals("I")) {//�ߺ��Ǵ� ���� �����Ҷ�
					if(treemap.get(n) != null) {
						treemap.put(n,treemap.get(n)+1);
					}else {
						treemap.put(n, 1);
					}
				}else {
					if(treemap.isEmpty()) continue;
					if(n == -1) { //�ּڰ�����
						int key = treemap.firstKey();
						if(treemap.get(key) == 1 ) {
							treemap.remove(key);
						}else {
							treemap.put(key,treemap.get(key)-1);
						}
						
					}else { //�ִ� �� ����
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
